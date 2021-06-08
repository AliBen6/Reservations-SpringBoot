package be.iccbxl.pid.service;

import java.time.LocalDateTime;
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
import be.iccbxl.pid.model.Show;
import be.iccbxl.pid.repository.ShowRepository;

@Service
public class ShowService {
	@Autowired
	private ShowRepository repository;

	public List<Show> getAll() {
		List<Show> shows = new ArrayList<>();

		repository.findAll().forEach(shows::add);

		return shows;
	}

	public Page<Show> findPaginated(Pageable pageable, String search) {
		List<Show> shows = new ArrayList<>();
		repository.findAll().forEach(shows::add);
		shows = shows.stream().filter(item -> {
			return item.getTitle().contains(search) || item.getSlug().contains(search)
					|| item.getDescription().contains(search);
		}).collect(Collectors.toList());
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Show> list;

		if (shows.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, shows.size());
			list = shows.subList(startItem, toIndex);
		}

		Page<Show> showPage = new PageImpl<Show>(list, PageRequest.of(currentPage, pageSize), shows.size());

		return showPage;
	}

	public Show get(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Show> show = repository.findById(indice);

		return show.isPresent() ? show.get() : null;
	}

	public void add(Show show) {
		show.setCreatedAt(LocalDateTime.now());
		repository.save(show);
	}

	public Show save(Show show) {
		return repository.save(show);
	}

	public void update(String id, Show show) {
		repository.save(show);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);

		repository.deleteById(indice);
	}

	public List<Show> getFromLocation(Location location) {
		return repository.findByLocation(location);
	}

	public Show findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}
}
