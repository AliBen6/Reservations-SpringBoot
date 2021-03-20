package be.iccbxl.pid.artist.dao.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.iccbxl.pid.artist.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

	List <Artist> findAll();
    
    Artist findById(long id);

    Long deleteById(long id);

    Artist save(Artist artist);
    
    Boolean existsById(long id);

}
