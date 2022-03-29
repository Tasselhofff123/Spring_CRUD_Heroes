package com.example.demo.services;

import com.example.demo.models.Hero;

import java.util.List;

public interface HeroService {
    Hero find(int id);
    List<Hero> findAll();
    void save(Hero hero);
    void update(Hero hero);
    void delete(int id);
}
