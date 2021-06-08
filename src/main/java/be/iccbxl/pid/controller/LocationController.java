package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.iccbxl.pid.model.Locality;
import be.iccbxl.pid.model.Location;
import be.iccbxl.pid.service.LocalityService;
import be.iccbxl.pid.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	private LocationService service;

	@Autowired
	private LocalityService localityService;

	@GetMapping("/locations")
	public String index2(Model model) {
		List<Location> locations = service.getAll();

		model.addAttribute("locations", locations);
		model.addAttribute("title", "List of locations");
		Location location = new Location();
		location.setLocality(new Locality());
		model.addAttribute("locationObj", location);
		model.addAttribute("subjects", localityService.getAll());

		return "locations/index";
	}

	@GetMapping("/locations/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Location location = service.get(id);

		model.addAttribute("location", location);
		model.addAttribute("title", "Fiche d'une localité");

		return "locations/show";
	}

	@PostMapping("/process_add_new_location")
	public String addNewLocation(Model model, Location location) {
		System.out.println("stef : " + location.getLocality().getId());
		Locality locality = localityService.getOne(location.getLocality().getId());
		location.setLocality(locality);
		service.add(location);
		return this.index2(model);
	}
}
