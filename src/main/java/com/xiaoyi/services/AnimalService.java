package com.xiaoyi.services;

import java.util.ArrayList;
import java.util.List;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.Items;
import com.xiaoyi.models.Orders;
import com.xiaoyi.models.enums.AnimalStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalService {
    private final AnimalStorageService animalStorage;

    public void addAnimal(Animal animal) {
        animalStorage.insertOrUpdate(animal);
    }

    public Animal getAnimalById(long id) {
        return animalStorage.queryAnimalById(id);
    }

//    public List<Animal> getAnimalByQuery(AnimalType animalType, BigDecimal lowestPrice,
//          BigDecimal highestPrice, String subType) {
//        return animalStorage.queryAnimal(animalType, lowestPrice, highestPrice, subType);
//    }

    public void sellerAnimal(long id) {
        Animal animal = animalStorage.queryAnimalById(id);
        animal.setStatus(AnimalStatus.SOLD_OUT);
        animalStorage.insertOrUpdate(animal);
    }
    
}
