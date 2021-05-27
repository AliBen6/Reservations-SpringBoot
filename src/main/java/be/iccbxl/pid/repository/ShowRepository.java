package be.iccbxl.pid.repository;

import java.util.List;

import be.iccbxl.pid.model.Location;
import be.iccbxl.pid.model.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends CrudRepository<Show, Long> {
    Show findBySlug(String slug);
    Show findByTitle(String title);
    List<Show> findByLocation(Location location);
}