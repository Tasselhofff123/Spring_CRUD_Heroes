package com.example.demo.controllers;

import com.example.demo.dao.ActorDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actors")
public class ActorController {
    private final ActorDAO actorDAO;

    public ActorController(ActorDAO actorDAO) {
        this.actorDAO = actorDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("actor", actorDAO.find(id));
        return "actors/actors";
    }
}
