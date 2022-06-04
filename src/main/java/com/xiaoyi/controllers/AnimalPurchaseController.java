package com.xiaoyi.controllers;

import com.xiaoyi.exceptions.NegativeBalanceException;
import com.xiaoyi.models.Animal;
import com.xiaoyi.services.AnimalService;
import com.xiaoyi.services.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AnimalPurchaseController {

    private final UserService userService;
    private final AnimalService animalService;

    public void purchaseAnimal(Animal animal) {
        try {
//            userService.pay(animal.getPrice());
            animalService.sellerAnimal(animal.getId());
        } catch (NegativeBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
