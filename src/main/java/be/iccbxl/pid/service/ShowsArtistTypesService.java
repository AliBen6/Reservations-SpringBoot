package be.iccbxl.pid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.model.Show;
import be.iccbxl.pid.model.ShowsArtistTypes;
import be.iccbxl.pid.repository.ShowsArtistTypesRepository;

@Service
public class ShowsArtistTypesService {

	@Autowired
	private ShowsArtistTypesRepository repository;

	public List<ShowsArtistTypes> findAllByShow(Show show) {
		return repository.findAllByShow(show);
	}

	public void save(ShowsArtistTypes sat) {
		repository.save(sat);
	}
}
