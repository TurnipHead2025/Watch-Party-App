package com.watchparty.session;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class WatchPartySessionController {
    private final WatchPartySessionService watchPartySessionService;    

    public WatchPartySessionController(WatchPartySessionService watchPartySessionService) {
        this.watchPartySessionService = watchPartySessionService;
    }

    //methods

    @GetMapping("/sessions")
    public List<WatchPartySession> getAllSessions() {
        return watchPartySessionService.getAllSessions();
    }  
    
    @GetMapping("/sessions/{id}")
    public WatchPartySession getSessionById(@PathVariable Long id) {
        return watchPartySessionService.getSessionById(id);
    }

    @PostMapping("/sessions")
    public WatchPartySession saveSession(@RequestBody WatchPartySession session) {
        return watchPartySessionService.saveSession(session);
    }

    @DeleteMapping("/sessions/{id}")
    public void deleteSession(@PathVariable Long id) {
        watchPartySessionService.deleteSession(id);
    }

    @PutMapping("/sessions/{id}")
    public WatchPartySession updateSession(@PathVariable Long id, @RequestBody WatchPartySession updatedSession) {
        return watchPartySessionService.updateSession(id, updatedSession);
    }
    
    
    
    

    
}
