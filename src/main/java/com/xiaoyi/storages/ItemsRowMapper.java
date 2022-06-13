package com.xiaoyi.storages;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xiaoyi.exceptions.DBMapperException;
import com.xiaoyi.models.Items;

public class ItemsRowMapper implements RowMapper<Items> {

    @Override
    public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
                return Items.builder()
                        .id(rs.getLong("id"))
                        .price(rs.getInt("price"))
                        .amount(rs.getInt("amount"))
                        .orderId(rs.getInt("order_id"))
                        .goodId(rs.getLong("good_id"))
                        .build();
        }
        catch (Exception e) {
            throw new DBMapperException("Mapping Order Items fail for resultSet: ");
        }
    }
}
