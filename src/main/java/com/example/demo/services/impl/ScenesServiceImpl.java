package com.example.demo.services.impl;

import com.example.demo.models.Scenes;
import com.example.demo.repositories.ScenesRepository;
import com.example.demo.services.ScenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScenesServiceImpl implements ScenesService {
    private final ScenesRepository scenesRepository;

    @Autowired
    public ScenesServiceImpl(ScenesRepository scenesRepository) {
        this.scenesRepository = scenesRepository;
    }

    public List <Scenes> findAll(){
        return scenesRepository.findAll();
    }
}
