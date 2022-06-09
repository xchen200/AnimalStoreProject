package com.xiaoyi.storages;

import com.xiaoyi.models.User;
import com.xiaoyi.storages.constants.UserConstants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return  User.builder()
            .id(rs.getLong(UserConstants.ID))
            .username(rs.getString(UserConstants.NAME))
            .sex(rs.getString(UserConstants.SEX))
            .email(rs.getString(UserConstants.EMAIL))
            .mobile(rs.getString(UserConstants.MOBILE))
            .password(rs.getString(UserConstants.PASSWORD))
            .role(rs.getString(UserConstants.ROLE))
            .build();
    }
}
