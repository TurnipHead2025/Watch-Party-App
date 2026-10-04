
// The entire show
// Represents the entire show, holding show metadata and an ordered list of scenes[cite: 2].

import java.util.ArrayList;
import java.util.List;

public class Production {
    private String showId;
    private String title;
    private String mediaType;
    private List<Scene> scenes;

    //constructors
    public Production(){
        scenes = new ArrayList<>();
    }

    public Production(String inputShowId, String inputTitle, String inputMediaType, List<Scene> inputScenes){
        showId = inputShowId;
        title = inputTitle;
        mediaType = inputMediaType;
        scenes = inputScenes;
    }

    //Getters
    public String getShowId(){
        return showId;
    }
    
    public String getTitle(){
        return title;
    }

    public String getMediaType(){
        return mediaType;
    }

    public List<Scene> getScenes(){
        return scenes;
    }

    //Setters
    public void setShowId(String inputShowId){
        showId = inputShowId;
    }

    public void setTitle(String inputTitle){
        title = inputTitle;
    }

    public void setMediaType(String inputMediaType){
        mediaType = inputMediaType;
    }

    public void setScenes(List<Scene> inputScenes){
        scenes = inputScenes;
    }

    @Override
    public String toString(){
        return ("Show Id: " + showId +
        ", Title: " + title +
        ", Media Type: " + mediaType +
        ", Scenes: " + scenes
        );
    }
}


