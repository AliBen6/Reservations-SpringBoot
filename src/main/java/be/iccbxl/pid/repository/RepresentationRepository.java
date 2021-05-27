package be.iccbxl.pid.repository;

import java.time.LocalDateTime;
import java.util.List;

import be.iccbxl.pid.model.Location;
import be.iccbxl.pid.model.Representation;
import be.iccbxl.pid.model.Show;
import org.springframework.data.repository.CrudRepository;

public interface RepresentationRepository extends CrudRepository<Representation, Long> {
    List<Representation> findByShow(Show show);
    List<Representation> findByLocation(Location location);
    List<Representation> findByWhen(LocalDateTime when);
}