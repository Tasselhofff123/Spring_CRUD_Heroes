package com.example.demo.services;

import com.example.demo.models.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment find(int id);
    List<Equipment> findAll();
    void save(Equipment equipment);
    void update(Equipment equipment);
    void delete(int id);
}
