package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "hero")
public class Hero {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor")
    private Actor actor;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "hero_scenes",
            joinColumns = {@JoinColumn(name = "hero_id")},
            inverseJoinColumns = {@JoinColumn(name = "scene_id")}
    )
    private Set<Scenes> sceneNumbers = new HashSet<>();

    @Column(name = "ready")
    private boolean ready;

    public Hero(){}

    public Hero(int id, String name, Actor actor, Set<Scenes> sceneNumbers, boolean ready) {
        this.id = id;
        this.name = name;
        this.actor = actor;
        this.sceneNumbers = sceneNumbers;
        this.ready = ready;
    }

    public Set<Scenes> getSceneNumbers() {
        return sceneNumbers;
    }

    public void setSceneNumbers(Set<Scenes> sceneNumbers) {
        this.sceneNumbers = sceneNumbers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

}
