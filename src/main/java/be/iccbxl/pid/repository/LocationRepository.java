package be.iccbxl.pid.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import be.iccbxl.pid.model.Location;

public interface LocationRepository extends CrudRepository<Location, Long> {
    Location findByDesignation(String designation);
    Optional<Location> findById(Long id);
}