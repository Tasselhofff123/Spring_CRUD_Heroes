package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;

    @ManyToOne()
    @JoinColumn(name = "equipment")
    private Equipment equipment;

    public Actor(){}

    public Actor(int id, String name, int age, String email, Equipment equipment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.equipment = equipment;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
