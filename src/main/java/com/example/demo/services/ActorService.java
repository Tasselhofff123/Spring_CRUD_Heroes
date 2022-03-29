package com.example.demo.services;

import com.example.demo.models.Actor;


import java.util.List;

public interface ActorService {
    Actor find(int id);
    List<Actor> findAll();
    void save(Actor actor);
    void update(Actor actor);
    void delete(int id);
}
