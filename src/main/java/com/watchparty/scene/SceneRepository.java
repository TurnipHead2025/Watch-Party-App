package com.watchparty.scene;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SceneRepository extends JpaRepository<Scene, Long> {
}
