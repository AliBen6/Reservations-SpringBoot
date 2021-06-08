package be.iccbxl.pid.controller;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import be.iccbxl.pid.model.Role;
import be.iccbxl.pid.model.User;
import be.iccbxl.pid.service.RoleService;
import be.iccbxl.pid.service.UserService;

@Controller
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/login")
	public String loginPage() {
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			return "/home/home";
		}
		return "authentication/login";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			return "/home/home";
		}
		model.addAttribute("user", new User());
		model.addAttribute("title", "User registration");
		model.addAttribute("buttonTitle", "Sign up");
		return "/authentication/register";
	}

	@GetMapping("/profile")
	public String updateProfile(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		User temp = userService.getUserByLogin(userDetails.getUsername());
		model.addAttribute("user", temp);
		model.addAttribute("title", "Change profile");
		model.addAttribute("buttonTitle", "Save");
		return "/authentication/register";
	}

	@PostMapping("/process_register")
	public String processRegister(Model model, User user) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		try {
			// its update profile
			UserDetails userDetails = (UserDetails) auth.getPrincipal();
			User temp = userService.getUserByLogin(userDetails.getUsername());
			temp.setEmail(user.getEmail());
			temp.setFirstname(user.getFirstname());
			temp.setLastname(user.getLastname());
			temp.setLangue(user.getLangue());
			if (user.getNewPassword().equals(user.getPassword())) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				temp.setPassword(encodedPassword);
			} else {
				model.addAttribute("user", temp);
				return "/authentication/register";
			}
			userService.save(temp);
			return "/home/home";
		} catch (ClassCastException ex) {
			// not authenticated
		}

		Set<Role> roleList = new LinkedHashSet<>();
		roleList.add(roleService.findByRole("member"));
		user.setRoleList(roleList);
		System.out.println("Processing register : " + user);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setLangue("fr");

		userService.addUser(user);

		return "/authentication/login";
	}
}
