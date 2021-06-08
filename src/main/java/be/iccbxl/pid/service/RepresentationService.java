package be.iccbxl.pid.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.model.Location;
import be.iccbxl.pid.model.Representation;
import be.iccbxl.pid.repository.RepresentationRepository;
import be.iccbxl.pid.repository.UserRepresentationRepository;

@Service
public class RepresentationService {
	@Autowired
	private RepresentationRepository repository;

	@Autowired
	private UserRepresentationRepository userRepresentationRepository;

	public List<Representation> getAll() {
		List<Representation> representations = new ArrayList<>();

		repository.findAll().forEach(representations::add);

		return representations;
	}

	public Representation get(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Representation> representation = repository.findById(indice);

		return representation.isPresent() ? representation.get() : null;
	}

	public void add(Representation representation) {
		repository.save(representation);
	}

	public void update(String id, Representation representation) {
		repository.save(representation);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);

		repository.deleteById(indice);
	}

	public List<Representation> getFromLocation(Location location) {
		return repository.findByLocation(location);
	}

	public Page<Representation> findPaginated(Pageable pageable, String search) {
		List<Representation> Representations = new ArrayList<>();
		repository.findAll().forEach(Representations::add);
		Representations = Representations.stream().filter(item -> {
			return item.getShow().getTitle().contains(search) || item.getShow().getSlug().contains(search)
					|| item.getShow().getDescription().contains(search);
		}).collect(Collectors.toList());
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Representation> list;

		if (Representations.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, Representations.size());
			list = Representations.subList(startItem, toIndex);
		}

		Page<Representation> RepresentationPage = new PageImpl<Representation>(list,
				PageRequest.of(currentPage, pageSize), Representations.size());

		return RepresentationPage;
	}

	public Representation findOneById(Long representationId) {
		return repository.findById(representationId).orElse(null);
	}

	public void delete(Long representationId) {
		Representation representation = repository.findById(representationId).orElse(null);
		if (representation == null)
			return;
		userRepresentationRepository.findAllByRepresentation(representation)
				.forEach(ur -> userRepresentationRepository.delete(ur));
		System.out.println("Deleted user representations");
		repository.delete(representation);
		System.out.println("Deleted representation");
	}
}
