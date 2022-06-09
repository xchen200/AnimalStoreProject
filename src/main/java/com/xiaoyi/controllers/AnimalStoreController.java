package com.xiaoyi.controllers;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.PageElement;
import com.xiaoyi.models.Post;
import com.xiaoyi.services.AnimalStorageService;
import com.xiaoyi.services.PostsService;
import com.xiaoyi.storages.constants.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AnimalStoreController {

    @Autowired
    private AnimalStorageService animalStorageService;

    @Autowired
    private PostsService postsService;

    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();

        //Get all animals
        List<Animal> animals = animalStorageService.getAllAnimals();

        var pageElements = createPageElementsList(animals);

//        modelAndView.addObject("username", username);
        modelAndView.addObject("pageElements", pageElements);

        modelAndView.setViewName("home");
        return modelAndView;
    }

    private List<PageElement> createPageElementsList(List<Animal> animals) {
        List<PageElement> res = new ArrayList<>();
        for (var animal : animals) {
            var posts = postsService.getSelectedPostByAnimalId(animal.getId());
            res.add(createPageElementBasedOnAnimal(animal));
            for (var post :  posts) {
                res.add(createPageElementBasedOnPost(post));
            }
        }
        return res;
    }

    private PageElement createPageElementBasedOnAnimal(Animal animal) {
        return PageElement.builder()
                .id(animal.getId())
                .type(CommonConstants.ANIMAL)
                .name(animal.getName())
                .imageUrl(animal.getPictureUrl())
                .animalType(animal.getSubType())
                .price(animal.getPrice())
                .build();
    }

    private PageElement createPageElementBasedOnPost(Post post) {
        return PageElement.builder()
                .id(post.getId())
                .type(CommonConstants.POST)
                .imageUrl(post.getPictureUrl())
                .post(post.getPost())
                .author(post.getAuthor())
                .build();
    }
}
