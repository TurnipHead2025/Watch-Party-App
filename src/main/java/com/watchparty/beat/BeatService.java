package com.watchparty.beat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


// receive requests from a Controller 
// use BeatRepository to access the database
// return Beat data

@Service
public class BeatService {
    private final BeatRepository beatRepository;

    public BeatService(BeatRepository beatRepository) {
        this.beatRepository = beatRepository;
    }

    // Methods

    // Call BeatRepository's inherited findAll(Pageable) method. It retrieves one page of Beats from the database using the requested size and sorting.       
    public Page<Beat> getAllBeats(Pageable pageable) {
        return beatRepository.findAll(pageable);
    }

    //Calls BeatRepository inherited JPA method to get a beat by its ID from the database
    public Beat getBeatById(Long id) {
        return beatRepository.findById(id).orElse(null);
    }

    //Calls BeatRepository inherited JPA method to save a beat obj to the database
    public Beat saveBeat(Beat beat) {
        return beatRepository.save(beat);
    }

    //Calls BeatRepository inherited JPA method. It passes the ID to the repository to delete the beat with that ID from the database
    public void deleteBeat(Long id) {
        beatRepository.deleteById(id);
    }  
    
    //Update a beat in the database by its ID. It first checks if the beat exists, then 1. Get the content value from updatedBeat. 2. Set that value into existingBeat. 3. Save the updated existingBeat to the database. 4. Return the updated existingBeat.

    public Beat updateBeat(Long id, Beat updatedBeat) {
        Beat existingBeat = beatRepository.findById(id).orElse(null);
        if (existingBeat != null) {
            existingBeat.setContent(updatedBeat.getContent());
            existingBeat.setSetLayout(updatedBeat.getSetLayout());
            existingBeat.setLighting(updatedBeat.getLighting());
            existingBeat.setBlocking(updatedBeat.getBlocking());
            return beatRepository.save(existingBeat);
        }
        return null;
    }


}
