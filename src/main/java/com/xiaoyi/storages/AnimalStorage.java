package com.xiaoyi.storages;

import com.xiaoyi.exceptions.EntityNotFoundException;
import com.xiaoyi.models.Animal;
import com.xiaoyi.models.enums.AnimalType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalStorage {
    private final Map<Long, Animal> animalMap;
    private long count;

    public AnimalStorage() {
        animalMap = new HashMap<>();
        count = 0;
    }

    public void insertOrUpdate(Animal animal) {
        if (animal.getId() != null && animalMap.containsKey(animal.getId())) {
            /* Update */
            animalMap.put(animal.getId(), animal);
        } else {
            /* Insert */
            animal.setId(++count);
            animalMap.put(count, animal);
        }
    }

    public Animal queryAnimalById(long id) {
        if (!animalMap.containsKey(id)) {
            throw new EntityNotFoundException(String.format("Animal with id %d can not be found", id));
        }
        return animalMap.get(id);
    }

    public List<Animal> queryAnimal(AnimalType animalType, BigDecimal lowestPrice, BigDecimal highestPrice, String subType) {

        List<Animal> queryResults = new ArrayList<>(animalMap.values());

        if (animalType != null) {
            queryResults = queryResults.stream()
                    .filter(animal -> animal.getAnimalType().equals(animalType))
                    .collect(Collectors.toList());
        }

        if (lowestPrice != null) {
            queryResults = queryResults.stream()
                    .filter(animal -> animal.getPrice().compareTo(lowestPrice) >= 0)
                    .collect(Collectors.toList());
        }

        if (highestPrice != null) {
            queryResults = queryResults.stream()
                    .filter(animal -> animal.getPrice().compareTo(highestPrice) <= 0)
                    .collect(Collectors.toList());
        }

        if (subType != null) {
            queryResults = queryResults.stream()
                    .filter(animal -> animal.getSubType().equalsIgnoreCase(subType))
                    .collect(Collectors.toList());
        }

        return queryResults;
    }
}
