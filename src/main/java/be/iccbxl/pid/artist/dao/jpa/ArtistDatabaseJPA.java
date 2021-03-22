package be.iccbxl.pid.artist.dao.jpa;

import be.iccbxl.pid.artist.model.Artist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import be.iccbxl.pid.artist.dao.ArtistDao;

@Repository
@EnableJpaRepositories
@EnableTransactionManagement
public class ArtistDatabaseJPA implements ArtistDao{

	@Autowired
	private ArtistRepository artistRepository;

	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return artistRepository.findAll();
	}

	@Override
	public Artist findById(long id) {
		// TODO Auto-generated method stub
		return artistRepository.findById(id);
	}

	@Override
	public long deleteById(long id) {
		// TODO Auto-generated method stub
		artistRepository.deleteById(id);
		return id;
	}

	@Override
	public Artist save(Artist artist) {
		// TODO Auto-generated method stub
		return artistRepository.save(artist);
	}

	@Override
	public Boolean existsById(long id) {
		// TODO Auto-generated method stub
		return artistRepository.existsById(id);
	}

}
