package com.xiaoyi.services;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.enums.AnimalStatus;
import com.xiaoyi.models.enums.AnimalType;
import com.xiaoyi.storages.AnimalStorage;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class AnimalService {
    private final AnimalStorage animalStorage;

    public void addAnimal(Animal animal) {
        animalStorage.insertOrUpdate(animal);
    }

    public Animal getAnimalById(long id) {
        return animalStorage.queryAnimalById(id);
    }

    public List<Animal> getAnimalByQuery(AnimalType animalType, BigDecimal lowestPrice,
          BigDecimal highestPrice, String subType) {
        return animalStorage.queryAnimal(animalType, lowestPrice, highestPrice, subType);
    }

    public void sellerAnimal(long id) {
        Animal animal = animalStorage.queryAnimalById(id);
        animal.setStatus(AnimalStatus.SOLD_OUT);
        animalStorage.insertOrUpdate(animal);
    }
}
