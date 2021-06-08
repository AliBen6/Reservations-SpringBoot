package be.iccbxl.pid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.iccbxl.pid.model.Representation;
import be.iccbxl.pid.model.User;
import be.iccbxl.pid.model.UserRepresentation;

public interface UserRepresentationRepository extends JpaRepository<UserRepresentation, Long> {

	List<UserRepresentation> findAllByUser(User userDetails);

	List<UserRepresentation> findAllByRepresentation(Representation r);

}
