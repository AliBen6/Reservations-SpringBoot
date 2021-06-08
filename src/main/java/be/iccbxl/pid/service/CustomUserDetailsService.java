package be.iccbxl.pid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserDetails details = userService.getUserByLogin(login);
		if (details == null)
			throw new UsernameNotFoundException("Username not found!");
		return details;
	}

}
