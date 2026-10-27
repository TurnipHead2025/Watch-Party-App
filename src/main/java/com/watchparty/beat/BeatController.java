package com.watchparty.beat;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeatController {
	private final BeatService beatService;

	public BeatController(BeatService beatService) {
		this.beatService = beatService;
	}

    //methods

    //When an HTTP client sends a `GET` request to `/beats`, run the method directly below this annotation.
    // Ask `BeatService` for all the Beats, then return that list as the HTTP response.

	@GetMapping("/beats")
	public List<Beat> getAllBeats() {
		return beatService.getAllBeats();
	}

    //When an HTTP client sends a `GET` request to `/beats/{id}`, run the method directly below this annotation.
    // Ask `BeatService` for the Beat with the given ID, then return that Beat

    @GetMapping("/beats/{id}")
    public Beat getBeatById(@PathVariable Long id) {
        return beatService.getBeatById(id);
    }

    //The client sends Beat data in the request body, the controller passes it to the Service, and the Service saves it through the Repository.

    @PostMapping("/beats")
    public Beat createBeat(@RequestBody Beat beat) {
        return beatService.saveBeat(beat);
    }

    //The request body supplies the new field values. The controller passes the ID and Beat to the Service. The Service ask the Repository to find the existing Beat by ID. The Service updates the fields and asks the Repository to save the updated Beat.

    @PutMapping("/beats/{id}")
    public Beat updateBeat(@PathVariable Long id, @RequestBody Beat updatedBeat) {
        return beatService.updateBeat(id, updatedBeat);
    }

    //The controller passes the ID to the Service. The Service asks the Repository to delete the Beat with that ID.
    
    @DeleteMapping("/beats/{id}")
    public void deleteBeat(@PathVariable Long id) {
        beatService.deleteBeat(id);
    }

    
}
