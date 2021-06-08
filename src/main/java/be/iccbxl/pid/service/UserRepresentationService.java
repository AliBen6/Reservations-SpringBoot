package be.iccbxl.pid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.iccbxl.pid.model.User;
import be.iccbxl.pid.model.UserRepresentation;
import be.iccbxl.pid.repository.UserRepresentationRepository;

@Service
public class UserRepresentationService {

	@Autowired
	private UserRepresentationRepository repository;

	public UserRepresentation save(UserRepresentation userRepresentation) {
		return repository.save(userRepresentation);
	}

	public List<UserRepresentation> findAllByUser(User userDetails) {
		return repository.findAllByUser(userDetails);
	}
}
