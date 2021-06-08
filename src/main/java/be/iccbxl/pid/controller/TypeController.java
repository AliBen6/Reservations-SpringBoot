package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.iccbxl.pid.model.Type;
import be.iccbxl.pid.service.TypeService;

@Controller
public class TypeController {
	@Autowired
	TypeService service;

	@GetMapping("/types")
	public String index2(Model model) {
		List<Type> types = service.getAll();

		model.addAttribute("types", types);
		model.addAttribute("title", "Liste des types");
		model.addAttribute("typeObj", new Type());

		return "type/index";
	}

	@GetMapping("/types/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Type type = service.getType(id);

		model.addAttribute("type", type);
		model.addAttribute("title", "Fiche d'un type");

		return "type/show";
	}

	@PostMapping("/process_add_new_type")
	public String processRegister(Model model, Type type) {
		service.addType(type);
		List<Type> types = service.getAll();

		model.addAttribute("types", types);
		model.addAttribute("title", "Liste des types");
		model.addAttribute("typeObj", new Type());

		return "/type/index";
	}

}
