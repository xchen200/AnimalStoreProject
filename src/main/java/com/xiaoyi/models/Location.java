package com.xiaoyi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Location {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
