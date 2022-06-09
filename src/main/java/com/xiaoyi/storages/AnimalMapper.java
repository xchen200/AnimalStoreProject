package com.xiaoyi.storages;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xiaoyi.exceptions.DBMapperException;
import com.xiaoyi.models.Animal;
import com.xiaoyi.models.animals.Cat;
import com.xiaoyi.models.animals.Dog;
import com.xiaoyi.models.enums.AnimalType;
import com.xiaoyi.models.enums.CatType;
import com.xiaoyi.models.enums.DogType;
import com.xiaoyi.storages.constants.AnimalConstants;

public class AnimalMapper implements RowMapper<Animal> {

    @Override
    public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            AnimalType type = AnimalType.valueOf(rs.getString(AnimalConstants.ANIMAL_TYPE));
            if (type == AnimalType.CAT) {
                return Cat.builder()
                        .id(rs.getLong(AnimalConstants.ID))
                        .name(rs.getString(AnimalConstants.NAME))
                        .price(rs.getInt(AnimalConstants.PRICE))
                        .animalType(AnimalType.CAT)
                        .catType(CatType.valueOf(rs.getString(AnimalConstants.SUB_TYPE)))
                        .pictureUrl(rs.getString(AnimalConstants.PICTURE_URL))
                        .pictureUrl1(rs.getString(AnimalConstants.PICTURE_URL1))
                        .pictureUrl2(rs.getString(AnimalConstants.PICTURE_URL2))
                        .intro(rs.getString(AnimalConstants.INTRO))
                        .build();
            } else {
                return Dog.builder()
                        .id(rs.getLong(AnimalConstants.ID))
                        .name(rs.getString(AnimalConstants.NAME))
                        .price(rs.getInt(AnimalConstants.PRICE))
                        .animalType(AnimalType.DOG)
                        .dogType(DogType.valueOf(rs.getString(AnimalConstants.SUB_TYPE)))
                        .pictureUrl(rs.getString(AnimalConstants.PICTURE_URL))
                        .pictureUrl1(rs.getString(AnimalConstants.PICTURE_URL1))
                        .pictureUrl2(rs.getString(AnimalConstants.PICTURE_URL2))
                        .intro(rs.getString(AnimalConstants.INTRO))
                        .build();
            }
        }
        catch (Exception e) {
            throw new DBMapperException("Mapping animal fail for resultSet: ");
        }
    }
}
