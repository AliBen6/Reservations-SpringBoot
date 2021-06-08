package be.iccbxl.pid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.iccbxl.pid.model.Show;
import be.iccbxl.pid.model.ShowsArtistTypes;

public interface ShowsArtistTypesRepository extends JpaRepository<ShowsArtistTypes, Long> {

	List<ShowsArtistTypes> findAllByShow(Show show);

}
