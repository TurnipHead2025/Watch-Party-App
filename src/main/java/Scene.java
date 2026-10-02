import java.util.ArrayList;
import java.util.List;

// A chapter in the show
// Represents a specific scene in the show, holding scene metadata and an ordered list of beats

public class Scene {
    //instance varibles
    private int actNumber;
    private int sceneNumber;
    private String title;
    private List<Beat> beats;

    //constructors
    public Scene(){
        beats = new ArrayList<>();
    };

    public Scene(int inputActNumber, int inputSceneNumber, String inputTitle, List<Beat> inputBeats){
        actNumber =  inputActNumber;
        sceneNumber = inputSceneNumber;
        title = inputTitle;
        beats =inputBeats;
    }

    //Getters
    public int getActNumber(){
        return actNumber;
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

    //Setters
    public void setActNumber(int inputActNumber){
        actNumber =  inputActNumber;
    }

    public void setSceneNumber(int inputSceneNumber){
        sceneNumber = inputSceneNumber;
    }

    public void setTitle(String inputTitle){
        title = inputTitle;
    }

    public void setBeats(List<Beat> inputBeats){
        beats = inputBeats;
    }

    @Override
    public String toString(){
        return ("Act Number: " + actNumber +
            ", Scene Number: " + sceneNumber +
            ", Title: " + title +
            ", Beats: " + beats
        );
    }


}
