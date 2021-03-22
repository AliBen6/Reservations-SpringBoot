package be.iccbxl.pid.artist.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import be.iccbxl.pid.artist.model.Artist;
import be.iccbxl.pid.artist.service.ArtistService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/Reservations/V1/artists/")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtist() {
        
    	return ResponseEntity.ok(artistService.getAllArtist());
    
    }
    
    @GetMapping(path = "{id}")
    public ResponseEntity<Artist> getArtistById(
            @PathVariable("id") long id) {
    	if(artistService.artistExist(id))
    	{
    		return ResponseEntity.ok(
                    artistService.getArtistById(id));
    	}
    	
    	return ResponseEntity.notFound().build();
    	
         
    }
    
    @PostMapping
    public ResponseEntity<Void> addArtist(
    		@Valid @RequestBody Artist artist) {
    	
    	Artist artistAdded = artistService.addArtist(artist);
        
    	if (artistAdded == null)
            return ResponseEntity.noContent().build();
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(artistAdded.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteArtistById(
            @PathVariable("id") long id) {
    	
    	if(artistService.artistExist(id))
    	{
    		artistService.deleteArtistById(id);
            return ResponseEntity.ok().build();
    	}
    	
    	return ResponseEntity.notFound().build();
    	
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Void> updateArtistById(
            @PathVariable("id") long id,
            @NonNull @RequestBody Artist artist) {
    	
    	if(artistService.artistExist(id))
    	{
    		artist.setId(id);
    		artistService.updateArtist(artist);        
    		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
    		
    		return ResponseEntity.created(location).build();
    	}	
    	
    	return ResponseEntity.notFound().build();
    	
    }

}
