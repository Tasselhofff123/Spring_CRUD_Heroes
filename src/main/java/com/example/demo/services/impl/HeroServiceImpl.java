package com.example.demo.services.impl;

import com.example.demo.models.Hero;
import com.example.demo.repositories.HeroRepository;
import com.example.demo.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Hero find(int id) {
        Optional<Hero> foundHero = heroRepository.findById(id);
        return  foundHero.orElse(null);
    }
    @Override
    public List<Hero> findAll(){
        return heroRepository.findAll();
    }
    @Override
    public void save(Hero hero){
        heroRepository.save(hero);
    }

    @Override
    public void update(Hero updatedHero) {
        heroRepository.saveAndFlush(updatedHero);
    }
    @Override
    public void delete(int id) {
        heroRepository.deleteById(id);
    }
}
