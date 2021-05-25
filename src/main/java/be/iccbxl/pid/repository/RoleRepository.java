package be.iccbxl.pid.repository;

import org.springframework.data.repository.CrudRepository;
import be.iccbxl.pid.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
