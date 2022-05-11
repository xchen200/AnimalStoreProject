package com.xiaoyi.controllers;

import com.xiaoyi.exceptions.EntityNotFoundException;
import com.xiaoyi.models.Animal;
import com.xiaoyi.models.enums.AnimalType;
import com.xiaoyi.services.AnimalService;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class AnimalQueryController {

    private final AnimalService service;

    public List<Animal> getAllAnimal() {
        return service.getAnimalByQuery(null, null, null, null);
    }

    public List<Animal> queryAnimal(AnimalType animalType, BigDecimal lowestPrice,
        BigDecimal highestPrice, String subType) {
            return service.getAnimalByQuery(animalType, lowestPrice, highestPrice, subType);
    }

    public Animal getAnimalInfo(long id) {
        try {
            return service.getAnimalById(id);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
