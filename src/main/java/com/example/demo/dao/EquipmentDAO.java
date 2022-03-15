package com.example.demo.dao;

import com.example.demo.models.Equipment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EquipmentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Equipment show(int id) {
        return entityManager.find(Equipment.class, id);
    }

    public List<Equipment> index(){
        return (List<Equipment>) entityManager.createQuery("SELECT equipment from Equipment equipment")
                .getResultList();
    }

    public void save(Equipment equipment){
        entityManager.persist(equipment);
    }
}
