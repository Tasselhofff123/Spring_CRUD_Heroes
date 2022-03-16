package com.example.demo.controllers;

import com.example.demo.dao.EquipmentDAO;
import com.example.demo.models.Equipment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/equipments")
public class EquipmentController {

    private final EquipmentDAO equipmentDAO;

    public EquipmentController(EquipmentDAO equipmentDAO) {
        this.equipmentDAO = equipmentDAO;
    }


    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("equipment", equipmentDAO.find(id));
        return "equipments/equipment";
    }

    @GetMapping("/all")
    public String index(Model model){
        model.addAttribute("equipments", equipmentDAO.findAll());
        return "equipments/allEquipments";
    }

    @GetMapping("/new")
    public String newEquipment(Model model){
        model.addAttribute("equipment", new Equipment());
        return "equipments/newEquipment";
    }

    @PostMapping()
    public String createEquipment(@ModelAttribute("equipment") @Valid Equipment equipment,
    BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "newEquipment";
        equipmentDAO.save(equipment);
        return "redirect:/equipments/all";
    }
}

