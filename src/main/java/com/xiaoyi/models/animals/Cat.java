package com.xiaoyi.models.animals;

import com.xiaoyi.models.Animal;
import com.xiaoyi.models.enums.CatType;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Cat extends Animal {

    private final CatType catType;

    @Override
    public String getSubType() {
        return catType.name();
    }
}
