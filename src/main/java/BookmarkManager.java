
// The memory card
// Manages saving and loading playback bookmarks to track session progress

public class BookmarkManager {
    //instance variables
    private String lastSavedBeatId; //The unique name tag of the beat you stopped on (beat.beatId)
    private int savedSceneIndex; //The chapter number index (WatchPartySession.currentSceneIndex)
    private int savedBeatIndex; // How many beats into the scene (WatchPartySession.currentBeatIndex)

    //constructor
    public BookmarkManager() {
        lastSavedBeatId = "";
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
        lastSavedBeatId = currentBeat.getBeatId(); //Use the index from currentBeat to find the String ID of that beat
    }

    // Restores the session's playback position using the saved indices. (Mental map for me, please ignore if it confuses you. Passes in the current indexes saved from the saveBookmark getter methods to the restoreBoomark setters) 
    public void restoreBookmark(WatchPartySession session){
        session.setCurrentSceneIndex(savedSceneIndex);
        session.setCurrentBeatIndex(savedBeatIndex);
    }

    //Getters
    public String getLastSavedBeatId(){
        return lastSavedBeatId;
    }

    public int getSavedSceneIndex(){
        return savedSceneIndex;
    }

    public int getSavedBeatIndex(){
        return savedBeatIndex;
    }
}
