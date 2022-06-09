package com.xiaoyi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xiaoyi.models.Animal;
import com.xiaoyi.services.AnimalStorageService;

@Controller
public class AnimalQueryController {

    @Autowired
    private AnimalStorageService animalStorageService;

    @GetMapping("/animals")
    public ModelAndView getAnimalsByType(@RequestParam(required = false) String type) {
        ModelAndView modelAndView = new ModelAndView();

        
        return modelAndView;
    }

    @GetMapping("/animalDetail")
    public ModelAndView getAnimalsById(@RequestParam(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Animal animal = animalStorageService.queryAnimalById(id);
        modelAndView.addObject("animal", animal);
        
        modelAndView.setViewName("detail");
        return modelAndView;
    }
}
