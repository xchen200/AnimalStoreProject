package com.xiaoyi.storages;

import com.xiaoyi.models.Post;
import com.xiaoyi.storages.constants.PostConstants;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Post.builder()
                .id(rs.getLong(PostConstants.ID))
                .animalId(rs.getLong(PostConstants.AnimalID))
                .post(rs.getString(PostConstants.POST))
                .author(rs.getString(PostConstants.AUTHOR))
                .pictureUrl(rs.getString(PostConstants.IMAGE_URL))
                .build();
    }
}
