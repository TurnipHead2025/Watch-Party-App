package com.watchparty.bookmark;

import com.watchparty.beat.Beat;
import com.watchparty.production.Production;
import com.watchparty.scene.Scene;
import com.watchparty.session.WatchPartySession;

public class BookmarkManager {
    //instance variables
    private Long lastSavedBeatId;
    private int savedSceneIndex; //The chapter number index (WatchPartySession.currentSceneIndex)
    private int savedBeatIndex; // How many beats into the scene (WatchPartySession.currentBeatIndex)

    //constructor
    public BookmarkManager() {
        lastSavedBeatId = null;
        savedSceneIndex = 0;
        savedBeatIndex = 0;
    }

    //methods
    //Move through the layers of Production to BeatId. Stores it
    public void saveBookmark(WatchPartySession session){
        savedSceneIndex = session.getCurrentSceneIndex();
        savedBeatIndex = session.getCurrentBeatIndex();
        Production production = session.getProduction();
        Scene currentScene = production.getScenes().get(savedSceneIndex); //get full list of scenes. Pull out the index captured by savedSceneIndex
        Beat currentBeat = currentScene.getBeats().get(savedBeatIndex); //Use the index captured in currentScene. Pull out the beat object from savedBeatIndex
        lastSavedBeatId = currentBeat.getId();
    }

    // Restores the session's playback position using the saved indices. (Mental map for me, please ignore if it confuses you. Passes in the current indexes saved from the saveBookmark getter methods to the restoreBoomark setters) 
    public void restoreBookmark(WatchPartySession session){
        session.setCurrentSceneIndex(savedSceneIndex);
        session.setCurrentBeatIndex(savedBeatIndex);
    }

    //Getters
    public Long getLastSavedBeatId(){
        return lastSavedBeatId;
    }

    public int getSavedSceneIndex(){
        return savedSceneIndex;
    }

    public int getSavedBeatIndex(){
        return savedBeatIndex;
    }
}
