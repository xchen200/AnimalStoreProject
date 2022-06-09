package com.xiaoyi.services;

import com.xiaoyi.models.Post;
import com.xiaoyi.storages.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Post> getAllPosts() {
        String sql = "SELECT * FROM posts";

        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());

        return posts;
    }

    public List<Post> getSelectedPostByAnimalId(Long animalId) {
        String sql = "SELECT * FROM posts WHERE animalId = ?";

        List<Post> posts = jdbcTemplate.query(sql, new PostMapper(), animalId);

        return posts;
    }
}
