package com.example.demo.controllers;

import com.example.demo.services.impl.ActorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actors")
public class ActorController {
    private final ActorServiceImpl actorServiceImpl;

    public ActorController(ActorServiceImpl actorServiceImpl) {
        this.actorServiceImpl = actorServiceImpl;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("actor", actorServiceImpl.find(id));
        return "actors/actors";
    }
}
