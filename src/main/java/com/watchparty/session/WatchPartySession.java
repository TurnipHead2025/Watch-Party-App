package com.watchparty.session;
import com.watchparty.production.Production;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



// The active player
// Represents the active playback session, tracking playback state and the current position within the production.

@Entity
public class WatchPartySession {
    //instance variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Production production;
    private int currentSceneIndex;
    private int currentBeatIndex;
    private boolean isPlaying = false;

    //constructor
    public WatchPartySession() {
    }

    public WatchPartySession(Production inputProduction) {
    production = inputProduction;
    currentSceneIndex = 0;
    currentBeatIndex = 0;
    isPlaying = false;
}

    //methods
    public void play(){
        isPlaying = true;
    }

    public void pause(){
        isPlaying = false;
    }

    public void nextBeat(){
        if (!isPlaying){
            return; //if player is paused exit method
        }
        currentBeatIndex++;
    }

    public void previousBeat(){
        if (!isPlaying){
            return; //if player is paused exit method
        }
        if (currentBeatIndex > 0){ //can't go -1 (prevent IndexOutOfBoundsException)
            currentBeatIndex--; 
        }
    }

    //Getters
    public long getId(){
        return id;
    }

    public boolean isPlaying(){
        return isPlaying;
    }

    public int getCurrentSceneIndex(){
        return currentSceneIndex;
    }

    public int getCurrentBeatIndex(){
        return currentBeatIndex;
    }

    public Production getProduction(){
        return production;
    }

    //Setters
    public void setProduction(Production production) {
        this.production = production;
    }

    public void setCurrentSceneIndex(int currentSceneIndex) {
    this.currentSceneIndex = currentSceneIndex;
    }

    public void setCurrentBeatIndex(int currentBeatIndex) {
        this.currentBeatIndex = currentBeatIndex;
    }


}
