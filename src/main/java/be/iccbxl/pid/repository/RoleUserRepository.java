package be.iccbxl.pid.repository;


import be.iccbxl.pid.model.RoleUser;
import be.iccbxl.pid.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleUserRepository extends CrudRepository<RoleUser, Long> {
    List<RoleUser> findByUser(User user);

}
