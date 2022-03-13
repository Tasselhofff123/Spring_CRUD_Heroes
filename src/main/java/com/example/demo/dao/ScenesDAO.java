package com.example.demo.dao;

import com.example.demo.models.Scenes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ScenesDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public ScenesDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List <Scenes> getScenes(){
        List<Scenes> scenes = (List<Scenes>) entityManager
                .createQuery("select scene from Scenes scene")
                .getResultList();
        return scenes;
    }
}
