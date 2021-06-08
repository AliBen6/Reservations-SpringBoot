package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistType;
import be.iccbxl.pid.model.Type;
import be.iccbxl.pid.service.ArtistService;
import be.iccbxl.pid.service.ArtistTypeService;
import be.iccbxl.pid.service.TypeService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService service;

	@Autowired
	private TypeService typeService;

	@Autowired
	private ArtistTypeService artistTypeService;

	@GetMapping("/artists")
	public String index(Model model) {
		List<Artist> artists = service.getAllArtists();
		model.addAttribute("artists", artists);
		model.addAttribute("title", "Liste des artistes");
		model.addAttribute("artistObj", new Artist());

		return "artist/index";
	}

	@GetMapping("/artists/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Artist artist = service.getArtist(id);

		model.addAttribute("types", typeService.getAll());
		model.addAttribute("artist", artist);
		model.addAttribute("title", "Fiche d'un artiste");

		return "artist/show";
	}

	@PostMapping("/process_add_new_artist")
	public String processAddNewArtist(Model model, Artist artist) {

		service.save(artist);
		List<Artist> artists = service.getAllArtists();
		model.addAttribute("artists", artists);
		model.addAttribute("title", "Liste des artistes");
		model.addAttribute("artistObj", new Artist());
		return "/artist/index";
	}
//
//	@PostMapping("/process_add_new_artist_type")
//	public String processAddNewArtistType(Model model, @RequestParam("artistId") Long artistId,
//			@RequestParam("typeId") Long typeId) {
//		Artist artist = service.getOne(artistId);
//
//		Type type = typeService.findOneById(typeId);
//		type.getArtists().add(artist);
//		typeService.save(type);
//		artist = service.getOne(artistId);
//
//		model.addAttribute("types", typeService.getAll());
//		model.addAttribute("artist", artist);
//		model.addAttribute("title", "Fiche d'un artiste");
//
//		return "artist/show";
//	}

	@PostMapping("/process_add_new_artist_type")
	public String processAddNewArtistType(Model model, @RequestParam("artistId") Long artistId,
			@RequestParam("typeId") Long typeId) {
		Artist artist = service.getOne(artistId);
		Type type = typeService.findOneById(typeId);

		if (!artist.getTypes().stream().filter(t -> t.getId() == typeId).findAny().isPresent()) {
			ArtistType artistType = new ArtistType(artist, type);
			artistTypeService.save(artistType);
			artist = service.getOne(artistId);
			artist.getTypes().add(type);
		}
		model.addAttribute("types", typeService.getAll());
		model.addAttribute("artist", artist);
		model.addAttribute("title", "Fiche d'un artiste");

		return "artist/show";
	}

}
