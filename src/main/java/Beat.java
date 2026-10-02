
// A single moment in the scene
// Represents a single, atomic moment on stage, holding dialogue, lighting, set layout, and blocking.

public class Beat {

    //Instance variables or fields 
    private String beatId;
    private String lyrics;
    private String setLayout;
    private String lighting;
    private String blocking;

    //constructors

    //no arg
    public Beat(){}

    //parameterized
    public Beat(String inputBeatId,String inputLyrics, String inputSetLayout, String inputLighting, String inputBlocking ){
        beatId = inputBeatId;
        lyrics = inputLyrics;
        setLayout = inputSetLayout;
        lighting = inputLighting;
        blocking = inputBlocking;
    }

    //getters
    public String getBeatId(){
        return beatId;
    }

    public String getLyrics(){
        return lyrics;
    }

    public String getSetLayout(){
        return setLayout;
    }

    public String getLighting(){
        return lighting;
    }

    public String getBlocking(){
        return blocking;
    }

    //setters
    public void setBeatId(String inputBeatId){
         beatId = inputBeatId;
    }

    public void setLyrics(String inputLyrics){
        lyrics = inputLyrics;
    }

    public void setSetLayout(String inputSetLayout){
        setLayout = inputSetLayout;
    }

    public void setLighting(String inputLighting){
        lighting = inputLighting;
    }

    public void setBlocking(String inputBlocking){
        blocking = inputBlocking;
    }
    

    @Override
    public String toString(){
        return ("Beat Id: " + beatId + 
        ", Lyrics: " + lyrics + 
        ", Set Layout: " + setLayout + 
        ", Lighting: " + lighting + 
        ", Blocking: " + blocking);
    }
}
