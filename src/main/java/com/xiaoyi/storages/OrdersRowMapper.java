package com.xiaoyi.storages;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.xiaoyi.exceptions.DBMapperException;
import com.xiaoyi.models.Orders;

public class OrdersRowMapper implements RowMapper<Orders> {

    @Override
    public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
                return Orders.builder()
                        .id(rs.getInt("id"))
                        .total(rs.getInt("total"))
                        .amount(rs.getInt("amount"))
                        .status(rs.getByte("status"))
                        .paytype(rs.getByte("paytype"))
                        .systime(rs.getDate("systime"))
                        .username(rs.getString("user_name"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .address(rs.getString("address"))
                        .build();
        }
        catch (Exception e) {
            throw new DBMapperException("Mapping Orders fail for resultSet: ");
        }
    }
}
