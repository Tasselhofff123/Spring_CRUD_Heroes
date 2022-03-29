package com.example.demo.services.impl;

import com.example.demo.models.Actor;
import com.example.demo.repositories.ActorRepository;
import com.example.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor find(int id) {
        Optional<Actor> foundActor = actorRepository.findById(id);
        return foundActor.orElse(null);
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public void save(Actor actor) {
        actorRepository.save(actor);
    }

    @Override
    public void update(Actor actor) {
        actorRepository.saveAndFlush(actor);
    }

    @Override
    public void delete(int id) {
        actorRepository.deleteById(id);
    }
}
