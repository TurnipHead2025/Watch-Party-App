package com.watchparty.beat;
import com.watchparty.scene.Scene;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

// A single moment in the scene
// Represents a single, atomic moment on stage, holding dialogue, lighting, set layout, and blocking.

@Entity
public class Beat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String content;
    private String setLayout;
    private String lighting;
    @Lob
    private String blocking;
    @ManyToOne
    @JsonBackReference("scene-beats")
    private Scene scene;

    //constructors

    //no arg
    public Beat(){}

    //parameterized
    public Beat(String inputContent, String inputSetLayout, String inputLighting, String inputBlocking ){
        content = inputContent;
        setLayout = inputSetLayout;
        lighting = inputLighting;
        blocking = inputBlocking;
    }

    //getters
    public long getId(){
        return id;
    }

    public String getContent(){
        return content;
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

    public Scene getScene(){
        return scene;
    }

    //setters

    public void setContent(String inputContent){
        content = inputContent;
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

    public void setScene(Scene scene){
        this.scene = scene;
    }
    

    @Override
    public String toString(){
        return ("Beat Id: " + id + 
        ", Content: " + content + 
        ", Set Layout: " + setLayout + 
        ", Lighting: " + lighting + 
        ", Blocking: " + blocking);
    }
}
