package com.example.demo.repositories;

import com.example.demo.models.Scenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenesRepository extends JpaRepository<Scenes, Integer> {
}
