package be.iccbxl.pid.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import be.iccbxl.pid.model.Type;

public interface TypeRepository extends CrudRepository<Type, Long> {
	Type findByTypeName(String type);

	Optional<Type> findById(Long id);
}
