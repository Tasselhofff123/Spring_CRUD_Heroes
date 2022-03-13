package com.example.demo.dao;

import com.example.demo.models.Actor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ActorDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Actor> returnAllActors(){
        return (List<Actor>) entityManager.createQuery("SELECT actor from Actor actor")
                .getResultList();
    }

    public Actor show(int id) {
        System.out.println(entityManager.find(Actor.class, id));
        return entityManager.find(Actor.class, id);
    }
}
