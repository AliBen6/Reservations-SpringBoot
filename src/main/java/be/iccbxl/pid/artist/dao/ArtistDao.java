package be.iccbxl.pid.artist.dao;

import java.util.List;
import be.iccbxl.pid.artist.model.Artist;

public interface ArtistDao {

	List <Artist> findAll();
    
    Artist findById(long id);

    long deleteById(long id);

    Artist save(Artist artist);

	Boolean existsById(long id);
    
}
