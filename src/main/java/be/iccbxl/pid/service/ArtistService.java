package be.iccbxl.pid.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.repository.ArtistRepository;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;
	
	
	public List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<>();
		
		artistRepository.findAll().forEach(artists::add);
		
		return artists;
	}
	
	public Artist getArtist(String id) {
		Long indice = (long) (Integer.parseInt(id));

		return artistRepository.findById(indice).orElse(null);
		
	}

	public void addArtist(Artist artist) {
		artistRepository.save(artist);
	}

	public void updateArtist(String id, Artist artist) {
		artistRepository.save(artist);
	}

	public void deleteArtist(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		artistRepository.deleteById(indice);
	}

}
