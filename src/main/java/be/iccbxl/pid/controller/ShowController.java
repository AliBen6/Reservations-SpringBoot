package be.iccbxl.pid.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import be.iccbxl.pid.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import be.iccbxl.pid.model.ArtistType;
import be.iccbxl.pid.model.Show;
import be.iccbxl.pid.model.ShowsArtistTypes;
import lombok.Data;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ShowController {
	@Autowired
	private ShowService service;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ShowsArtistTypesService showsArtistTypesService;

	@Autowired
	private ArtistTypeService artistTypeService;

	@RequestMapping(value = "/showsPaginated", method = RequestMethod.GET)
	public String listShows(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		List<Show> shows = service.getAll();
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Show> showPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize), "");

		model.addAttribute("showPage", showPage);

		int totalPages = showPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("shows", shows);
		model.addAttribute("title", "Liste des spectacles");
		model.addAttribute("searchObj", new SearchObj());
		model.addAttribute("newShow", new Show());
		model.addAttribute("locations", locationService.getAll());
		return "show/index";
	}

	@Data
	class SearchObj {
		private String search;
	}

	@RequestMapping(value = "/showsPaginated", method = RequestMethod.POST)
	public String listBooks(Model model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size, SearchObj searchObj) {

		List<Show> shows = service.getAll();
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);

		Page<Show> showPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize), searchObj.getSearch());

		model.addAttribute("showPage", showPage);

		int totalPages = showPage.getTotalPages();
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}

		model.addAttribute("shows", shows);
		model.addAttribute("title", "Liste des spectacles");
		model.addAttribute("searchObj", new SearchObj());
		model.addAttribute("newShow", new Show());
		model.addAttribute("locations", locationService.getAll());
		return "show/index";
	}

	@PostMapping("/process_add_new_show")
	public String processRegister(Model model, Show show, @RequestParam("locationId") Long locationId) {
		show.setLocation(locationService.findOneById(locationId));
		service.add(show);
		return this.listShows(model, Optional.of(1), Optional.of(5));
	}

	@PostMapping("/process_add_new_shows_artist_type")
	public String process(Model model, Show show, @RequestParam("showId") Long showId,
			@RequestParam("artistTypeId") Long artistTypeId) {
		ShowsArtistTypes sat = new ShowsArtistTypes();
		ArtistType at = artistTypeService.findOneById(artistTypeId);
		Show s = service.findOneById(showId);
		sat.setArtisteType(at);
		sat.setShow(s);
		showsArtistTypesService.save(sat);
		return this.show(model, showId.toString());
	}

	@GetMapping("/shows/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Show show = service.get(id);

		List<ShowsArtistTypes> all = showsArtistTypesService.findAllByShow(show);
		List<ArtistType> artistTypeList = new ArrayList<>();

		System.out.println("All:");
		all.forEach(item -> System.out.println(item));

		all.forEach(item -> {
			ArtistType k = artistTypeService.findOneById(item.getArtisteType().getId());
			artistTypeList.add(k);
		});

		artistTypeList.forEach(l -> System.out.println(l));
		model.addAttribute("show", show);
		model.addAttribute("title", "Fiche d'un spectacle");
		model.addAttribute("artistTypes", artistTypeList);
		model.addAttribute("artistTypesCodebook", artistTypeService.findAll());

		return "show/show";
	}

	@GetMapping("/show/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=shows_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);

		List<Show> listShows = service.getAll();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"Show Id", "Slug", "Title", "Description", "Poster url", "Location","Bookable","price"};
		String[] nameMapping = {"id", "slug", "title", "description", "posterUrl", "location","bookable","price"};

		csvWriter.writeHeader(csvHeader);

		for (Show show : listShows) {
			csvWriter.write(show, nameMapping);
		}

		csvWriter.close();

	}
}