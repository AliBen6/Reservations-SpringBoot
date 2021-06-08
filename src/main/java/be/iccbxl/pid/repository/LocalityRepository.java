package be.iccbxl.pid.repository;

import org.springframework.data.repository.CrudRepository;

import be.iccbxl.pid.model.Locality;

public interface LocalityRepository extends CrudRepository<Locality, Long> {
	Locality findByPostalCode(String postalCode);

	Locality findByLocalityName(String locality);
}
