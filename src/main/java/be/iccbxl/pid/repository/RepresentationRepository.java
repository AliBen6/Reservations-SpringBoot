package be.iccbxl.pid.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.iccbxl.pid.model.Location;
import be.iccbxl.pid.model.Representation;
import be.iccbxl.pid.model.Show;

public interface RepresentationRepository extends JpaRepository<Representation, Long> {
	List<Representation> findByShow(Show show);

	List<Representation> findByWhen(LocalDateTime when);

	List<Representation> findByLocation(Location location);
}