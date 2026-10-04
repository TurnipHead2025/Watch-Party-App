
// The active player
// Represents the active playback session, tracking playback state and the current position within the production.


public class WatchPartySession {
    //instance variables
    private Production production;
    private int currentSceneIndex;
    private int currentBeatIndex;
    private boolean isPlaying = false;

    //constructor
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
    public void setCurrentSceneIndex(int currentSceneIndex) {
    this.currentSceneIndex = currentSceneIndex;
    }

    public void setCurrentBeatIndex(int currentBeatIndex) {
        this.currentBeatIndex = currentBeatIndex;
    }


}
