package com.xiaoyi.models;

import com.xiaoyi.models.enums.AnimalStatus;
import com.xiaoyi.models.enums.AnimalType;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Animal {
    private Long id;
    private String name;
    private String seller;
    private String mobile;
    private String email;
    private Integer price;

    @Builder.Default
    private AnimalStatus status = AnimalStatus.AVAILABLE;
    private String pictureUrl;
    private Location location;
    private AnimalType animalType;

    public abstract String getSubType();
    
    private String pictureUrl1;
    private String pictureUrl2; 
    private String intro;


    @Override
    public String toString() {
        return String.format("id %d, %s, type %s, name %s, price %s, status %s", id,
                animalType.name(), getSubType(), name, price.toString(), status.name());
    }
}
