package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

// Модель оборудования актёров
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "audiointerface")
    private String audioInterface;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "microphone")
    private String microphone;

    @Column(name = "popfilter")
    private boolean popFilter;
    @Column(name="soundproofing")
    private boolean soundproofing;

    public Equipment(){
    }

    public Equipment(int id, String audioInterface, String microphone, boolean popFilter, boolean soundproofing) {
        this.id = id;
        this.audioInterface = audioInterface;
        this.microphone = microphone;
        this.popFilter = popFilter;
        this.soundproofing = soundproofing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAudioInterface() {
        return audioInterface;
    }

    public void setAudioInterface(String audioInterface) {
        this.audioInterface = audioInterface;
    }

    public String getMicrophone() {
        return microphone;
    }

    public void setMicrophone(String microphone) {
        this.microphone = microphone;
    }

    public boolean isPopFilter() {
        return popFilter;
    }

    public void setPopFilter(boolean popFilter) {
        this.popFilter = popFilter;
    }

    public boolean isSoundproofing() {
        return soundproofing;
    }

    public void setSoundproofing(boolean soundproofing) {
        this.soundproofing = soundproofing;
    }
}
