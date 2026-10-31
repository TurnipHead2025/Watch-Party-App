package com.watchparty.scene;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SceneController {
    final private SceneService sceneService;

    public SceneController(SceneService sceneService) {
        this.sceneService = sceneService;
    }


    //methods

    @GetMapping("/scenes")
    public List<Scene> getAllScenes() {
        return sceneService.getAllScenes();
    }

    @GetMapping("/scenes/{id}")
    public Scene getSceneById(@PathVariable Long id) {
        return sceneService.getSceneById(id);
    }

    @PostMapping("/scenes")
    public Scene saveScene(@RequestBody Scene scene) {
        return sceneService.saveScene(scene);
    }

    @DeleteMapping("/scenes/{id}")
    public void deleteScene(@PathVariable Long id) {
        sceneService.deleteScene(id);
    }

    @PutMapping("/scenes/{id}")
    public Scene updateScene(@PathVariable Long id, @RequestBody Scene updatedScene) {
        return sceneService.updateScene(id, updatedScene);
    } 
}  


    




