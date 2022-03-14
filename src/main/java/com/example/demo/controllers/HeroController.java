package com.example.demo.controllers;

import com.example.demo.dao.ActorDAO;
import com.example.demo.dao.HeroDAO;
import com.example.demo.dao.ScenesDAO;
import com.example.demo.models.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private final HeroDAO heroDAO;
    private final ActorDAO actorDAO;
    private final ScenesDAO scenesDAO;

    public HeroController(HeroDAO heroDAO, ActorDAO actorDAO, ScenesDAO scenesDAO) {
        this.heroDAO = heroDAO;
        this.actorDAO = actorDAO;
        this.scenesDAO = scenesDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("hero", heroDAO.show(id));
        return "hero";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("heroes", heroDAO.index());
        return "index";
    }

    @GetMapping("/new")
    public String newHero(Model model){
        model.addAttribute("hero", new Hero());
        model.addAttribute("scenes", scenesDAO.getScenes());
        model.addAttribute("actors", actorDAO.returnAllActors());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("hero") @Valid Hero hero, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "new";}
        heroDAO.save(hero);
        return "redirect:/heroes/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("hero", heroDAO.show(id));
        return "edit";
    }

}
