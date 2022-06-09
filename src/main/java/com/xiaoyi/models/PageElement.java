package com.xiaoyi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageElement {
    private Long id;
    private String type;
    private String imageUrl;
    private String name;

    //For post
    private String post;
    private String author;

    //For animal
    private String animalType;
    private Integer price;

}
