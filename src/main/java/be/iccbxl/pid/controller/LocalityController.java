package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.iccbxl.pid.model.Locality;
import be.iccbxl.pid.service.LocalityService;

@Controller
public class LocalityController {
	@Autowired
	private LocalityService service;

	@GetMapping("/localities")
	public String index2(Model model) {
		List<Locality> localities = service.getAll();

		model.addAttribute("localities", localities);
		model.addAttribute("title", "Liste des localités");
		model.addAttribute("localityObj", new Locality());

		return "locality/index";
	}

	@GetMapping("/localities/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Locality locality = service.get(id);

		model.addAttribute("locality", locality);
		model.addAttribute("title", "Fiche d'une localité");

		return "locality/show";
	}

	@PostMapping("/process_add_new_locality")
	public String processRegister(Model model, Locality localityObj) {

		service.add(localityObj);
		List<Locality> localities = service.getAll();
		model.addAttribute("localities", localities);
		model.addAttribute("title", "Liste des localités");
		model.addAttribute("localityObj", new Locality());
		return "/locality/index";
	}

}
