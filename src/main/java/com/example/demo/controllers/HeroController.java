package com.example.demo.controllers;

import com.example.demo.services.impl.ActorServiceImpl;
import com.example.demo.services.impl.HeroServiceImpl;
import com.example.demo.services.impl.ScenesServiceImpl;
import com.example.demo.models.Hero;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private final HeroServiceImpl heroServiceImpl;
    private final ActorServiceImpl actorServiceImpl;
    private final ScenesServiceImpl scenesServiceImpl;

    public HeroController(HeroServiceImpl heroServiceImpl, ActorServiceImpl actorServiceImpl, ScenesServiceImpl scenesServiceImpl) {
        this.heroServiceImpl = heroServiceImpl;
        this.actorServiceImpl = actorServiceImpl;
        this.scenesServiceImpl = scenesServiceImpl;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("hero", heroServiceImpl.find(id));
        return "heroes/hero";
    }

    @GetMapping("/all")
    public String index(Model model){
        model.addAttribute("heroes", heroServiceImpl.findAll());
        return "heroes/allHeroes";
    }

    @GetMapping("/new")
    public String newHero(Model model){
        model.addAttribute("hero", new Hero());
        model = addScenesAndActors(model);
        return "heroes/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("hero") @Valid Hero hero, BindingResult bindingResult,
                        Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("hero", hero);
            model = addScenesAndActors(model);
            return "heroes/new";}
        heroServiceImpl.save(hero);
        return "redirect:/heroes/all";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("hero", heroServiceImpl.find(id));
        model = addScenesAndActors(model);
        return "heroes/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("hero") @Valid Hero hero,
                          BindingResult bindingResult, @PathVariable("id") int id, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("hero", hero);
            model = addScenesAndActors(model);
            return "heroes/edit";
        }
        System.out.println("I will update now");
        heroServiceImpl.update(hero);
        return "redirect:/heroes/all";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        heroServiceImpl.delete(id);
        return "redirect:/heroes/all";
    }

    private Model addScenesAndActors(Model model){
        model.addAttribute("scenes", scenesServiceImpl.findAll());
        model.addAttribute("actors", actorServiceImpl.findAll());
        return model;
    }

}
