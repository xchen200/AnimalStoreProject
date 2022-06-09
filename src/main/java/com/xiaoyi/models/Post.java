package com.xiaoyi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
    private Long id;
    private Long animalId;
    private String post;
    private String pictureUrl;
    private String author;
}
