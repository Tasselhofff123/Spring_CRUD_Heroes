package com.example.demo.services.impl;

import com.example.demo.models.Equipment;
import com.example.demo.repositories.EquipmentRepository;
import com.example.demo.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentServiceImpl(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment find(int id) {
        Optional<Equipment> foundEquipment = equipmentRepository.findById(id);
        return foundEquipment.orElse(null);
    }

    @Override
    public List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void update(Equipment equipment) {
        equipmentRepository.saveAndFlush(equipment);
    }

    @Override
    public void delete(int id) {
        equipmentRepository.deleteById(id);
    }
}
