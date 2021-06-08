package be.iccbxl.pid.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.iccbxl.pid.model.Representation;
import be.iccbxl.pid.model.User;
import be.iccbxl.pid.model.UserRepresentation;
import be.iccbxl.pid.service.LocationService;
import be.iccbxl.pid.service.RepresentationService;
import be.iccbxl.pid.service.ShowService;
import be.iccbxl.pid.service.UserRepresentationService;
import be.iccbxl.pid.service.UserService;
import lombok.Data;

@Controller
public class RepresentationController {
	@Autowired
	RepresentationService service;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ShowService showService;

	@Autowired
	private RepresentationService representationService;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepresentationService userRepresentationService;

	@GetMapping("/representations")
	public String index(Model model) {
		List<Representation> representations = service.getAll();

		model.addAttribute("representations", representations);
		model.addAttribute("title", "Liste des representations");

		return "representation/index";
	}

	@RequestMapping(value = "/representationsPaginated", method = RequestMethod.GET)
	public String listRepresentations(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		List<Representation> representations = service.getAll();
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Representation> representationPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize), "");

		model.addAttribute("representationPage", representationPage);

		int totalPages = representationPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("representations", representations);
		model.addAttribute("title", "Liste des spectacles");
		model.addAttribute("searchObj", new SearchObj());
		model.addAttribute("newRepresentation", new Representation());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("shows", showService.getAll());
		model.addAttribute("dateTimeModel", new DateTimeModel());
		return "representation/index";
	}

	@RequestMapping(value = "/representationsPaginated", method = RequestMethod.POST)
	public String paginatedPost(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size, SearchObj searchObj) {

		List<Representation> representations = service.getAll();
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Representation> representationPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize),
				searchObj.getSearch());

		model.addAttribute("representationPage", representationPage);

		int totalPages = representationPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("representations", representations);
		model.addAttribute("title", "Liste des spectacles");
		model.addAttribute("searchObj", new SearchObj());
		model.addAttribute("newRepresentation", new Representation());
		model.addAttribute("locations", locationService.getAll());
		model.addAttribute("shows", showService.getAll());
		model.addAttribute("dateTimeModel", new DateTimeModel());
		return "representation/index";
	}

	@PostMapping("/process_book_show")
	public String booking(Model model, @RequestParam("representationId") Long representationId) {
		/*
		 * To do, do reservation
		 */

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Representation representation = representationService.findOneById(representationId);
		UserDetails userDetails = (UserDetails) auth.getPrincipal();

		UserRepresentation userRepresentation = new UserRepresentation();
		userRepresentation.setRepresentation(representation);
		userRepresentation.setUser(userService.getUserByLogin(userDetails.getUsername()));

		// userRepresentation.setPlaces(userRepresentation.getPlaces() + 1);

		userRepresentationService.save(userRepresentation);
		return this.listRepresentations(model, Optional.of(1), Optional.of(5));
	}

	@Data
	class DateTimeModel {
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private LocalDate date;
		@DateTimeFormat(pattern = "HH:mm")
		private LocalTime time;
	}

	@PostMapping("/process_add_new_representation")
	public String processRegister(Model model, Representation representation,
			@RequestParam("locationId") Long locationId, @RequestParam("showId") Long showId,
			DateTimeModel dateTimeModel) {
		System.out.println(dateTimeModel.getDate());
		System.out.println(dateTimeModel.getTime());
		representation.setLocation(locationService.findOneById(locationId));
		representation.setWhen(LocalDateTime.of(dateTimeModel.getDate(), dateTimeModel.getTime()));
		representation.setShow(showService.findOneById(showId));
		service.add(representation);
		return this.listRepresentations(model, Optional.of(1), Optional.of(5));
	}

	@GetMapping("/myReservations")
	public String processRegister(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userDetails = (User) auth.getPrincipal();
		model.addAttribute("userRepresentations", userRepresentationService.findAllByUser(userDetails));

		return "userrepresentations/index";
	}

	@GetMapping("/representations/delete/{id}")
	public String delete(Model model, @PathVariable("id") String representationId) {
		service.delete((long) Integer.parseInt(representationId));
		return this.listRepresentations(model, Optional.of(1), Optional.of(5));
	}

	@Data
	class SearchObj {
		private String search;
	}

}