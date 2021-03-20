package be.iccbxl.pid.artist.dao;

import java.util.List;
import be.iccbxl.pid.artist.model.Artist;

public interface ArtistDao {

	public List <Artist> findAll();
    
    public Artist findById(long id);

    public long deleteById(long id);

    public Artist save(Artist artist);

	public Boolean existsById(long id);
    
}
