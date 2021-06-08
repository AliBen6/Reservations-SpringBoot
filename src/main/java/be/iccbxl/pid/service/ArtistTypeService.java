package be.iccbxl.pid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.model.ArtistType;
import be.iccbxl.pid.repository.ArtistTypeRepository;

@Service
public class ArtistTypeService {

	@Autowired
	private ArtistTypeRepository repository;

	public ArtistType save(ArtistType artistType) {
		return repository.save(artistType);
	}

	public ArtistType findOneById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<ArtistType> findAll() {
		return repository.findAll();
	}

}
