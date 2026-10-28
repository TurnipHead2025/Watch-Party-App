package com.watchparty.scene;
import java.util.ArrayList;
import java.util.List;

import com.watchparty.beat.Beat;
import com.watchparty.production.Production;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

// A chapter in the show
// Represents a specific scene in the show, holding scene metadata and an ordered list of beats

@Entity
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int sceneNumber;
    private String title;
    @OneToMany(mappedBy = "scene", cascade = CascadeType.ALL)
    @JsonManagedReference("scene-beats")
    private List<Beat> beats;
    @ManyToOne
    @JsonBackReference("production-scenes")
    private Production production;
     //casacde is a feature in JPA that allows an operation applied to one object to automatically continue to related objects

    //constructors
    public Scene(){
        beats = new ArrayList<>();
    };

    public Scene(int inputSceneNumber, String inputTitle, List<Beat> inputBeats, Production inputProduction){
        sceneNumber = inputSceneNumber;
        title = inputTitle;
        beats =inputBeats;
        production = inputProduction;
    }

    //Getters
    public long getId(){
        return id;
    }
    
    public int getSceneNumber(){
        return sceneNumber;
    }

    public String getTitle(){
        return title;
    }

    public List<Beat> getBeats(){
        return beats;
    }

    public Production getProduction(){
        return production;
    }

    //Setters
    public void setSceneNumber(int inputSceneNumber){
        sceneNumber = inputSceneNumber;
    }

    public void setTitle(String inputTitle){
        title = inputTitle;
    }

    public void setBeats(List<Beat> inputBeats){
        beats = inputBeats;
    }

    public void setProduction(Production production) {
    this.production = production;
}

    @Override
    public String toString(){
        return (
            ", ID: " + id +
            ", Scene Number: " + sceneNumber +
            ", Title: " + title +
            ", Beats: " + beats +
            ", Production: " + production
        );
    }


}
