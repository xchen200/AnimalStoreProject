package com.xiaoyi.models.animals;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.enums.DogType;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Dog extends Animal {

    private final DogType dogType;

    @Override
    public String getSubType() {
        return dogType.name();
    }
}
