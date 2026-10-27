package com.watchparty.scene;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class SceneService {
    private final SceneRepository sceneRepository;

    public SceneService(SceneRepository sceneRepository) {
        this.sceneRepository = sceneRepository;
    }


    //methods

    public List<Scene> getAllScenes() {
        return sceneRepository.findAll();
    }

    public Scene getSceneById(Long id) {
        return sceneRepository.findById(id).orElse(null);
    }

    public Scene saveScene(Scene scene) {
        return sceneRepository.save(scene);
    }

    public void deleteScene(Long id) {
        sceneRepository.deleteById(id);
    }   

    public Scene updateScene(Long id, Scene updatedScene) {
        Scene existingScene = sceneRepository.findById(id).orElse(null);
        if (existingScene != null) {
            existingScene.setSceneNumber(updatedScene.getSceneNumber());
            existingScene.setTitle(updatedScene.getTitle());
            existingScene.setBeats(updatedScene.getBeats());
            existingScene.setProduction(updatedScene.getProduction());
            return sceneRepository.save(existingScene);
        }
        return null;
    }
}
