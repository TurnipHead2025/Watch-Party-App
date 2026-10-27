package com.watchparty.production;
import java.util.ArrayList;
import java.util.List;

import com.watchparty.scene.Scene;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



// The entire show
// Represents the entire show, holding show metadata and an ordered list of scenes

@Entity
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String mediaType;
    private String description;
    @OneToMany(mappedBy = "production")
    private List<Scene> scenes;

    //constructors
    public Production(){
        scenes = new ArrayList<>();
    }

    public Production(String inputTitle, String inputMediaType, List<Scene> inputScenes, String inputDescription){
        title = inputTitle;
        mediaType = inputMediaType;
        scenes = inputScenes;
        description = inputDescription;
    }

    //Getters
    public long getId(){
        return id;
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

    public String getDescription(){
        return description;
    }

    //Setters
    public void setTitle(String inputTitle){
        title = inputTitle;
    }

    public void setMediaType(String inputMediaType){
        mediaType = inputMediaType;
    }

    // Updates the relationship between the Production and its Scenes.
    public void setScenes(List<Scene> inputScenes){
        scenes = inputScenes;
    }

    public void setDescription(String inputDescription){
        description = inputDescription;
    }

    @Override
    public String toString(){
        return ("Show Id: " + id +
        ", Title: " + title +
        ", Media Type: " + mediaType +
        ", Scenes: " + scenes +
        ", Description: " + description
        );
    }
}


