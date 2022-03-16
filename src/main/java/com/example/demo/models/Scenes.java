package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//Модель сцены
@Entity
@Table(name = "scenes")
public class Scenes {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "scenenumber")
    private int sceneNumber;

    @ManyToMany(mappedBy = "sceneNumbers")
    private Set<Hero> heroes = new HashSet<>();

    public Scenes(int id, int sceneNumber, Set<Hero> heroes) {
        this.id = id;
        this.sceneNumber = sceneNumber;
        this.heroes = heroes;
    }

    public Scenes(){}

    public Set<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(Set<Hero> heroes) {
        this.heroes = heroes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSceneNumber() {
        return sceneNumber;
    }

    public void setSceneNumber(int sceneNumber) {
        this.sceneNumber = sceneNumber;
    }
}
