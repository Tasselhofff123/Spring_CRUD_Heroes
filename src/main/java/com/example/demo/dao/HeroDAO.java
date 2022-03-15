package com.example.demo.dao;

import com.example.demo.models.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class HeroDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public HeroDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public Hero show(int id) {
        return entityManager.find(Hero.class, id);
    }

    public List<Hero> index(){
        return (List<Hero>) entityManager.createQuery("SELECT hero from Hero hero")
                .getResultList();
    }

    public void save(Hero hero){
        entityManager.persist(hero);
    }

    public void update(int id, Hero updatedHero) {
        Hero hero = show(id);
        entityManager.detach(hero);
        hero = updatedHero;
        entityManager.merge(hero);
    }

    public void delete(int id) {
        entityManager.remove(show(id));
    }
}
