package be.iccbxl.pid.artist.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.artist.dao.ArtistDao;
import be.iccbxl.pid.artist.model.Artist;

@Service
public class ArtistService {
	
	private static final Logger LOG = LoggerFactory.getLogger(ArtistService.class);

    @Autowired
    private ArtistDao artistDAO;

    /*
    @Autowired
    private ArtistDAOProducer artistDAOProducer;
	*/

    public Artist addArtist(Artist artist) {
        Artist artistInserted = artistDAO.save(artist);

      //artistDAOProducer.sendNewArtist(artist);
        
        return artistInserted;

    }

    public List<Artist> getAllArtist() {
         return artistDAO.findAll();
    }

    public Artist getArtistById(long id) {
        return artistDAO.findById(id);
    }

    public long deleteArtistById(long id) {
        return artistDAO.deleteById(id);
    }

    public Artist updateArtist(Artist artist){
        return artistDAO.save(artist);
    }

    public Boolean artistExist(long id) {
    	return artistDAO.existsById(id);
    }


}
