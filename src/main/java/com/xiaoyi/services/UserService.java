package com.xiaoyi.services;

import com.xiaoyi.models.User;
import com.xiaoyi.storages.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findByUserName(String username) {

        String sql = "SELECT * FROM customers WHERE name = ?";

        return jdbcTemplate.query(sql, new UserRowMapper(), username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String sql = "SELECT * FROM customers WHERE name = ?";

        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), username);

        if (users.size() > 0) {
            var user = users.get(0);
            return buildUserForAuthentication(user, List.of(getUserAuthority(user.getRole())));
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private GrantedAuthority getUserAuthority(String role) {
        return new SimpleGrantedAuthority(role);
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                true, true, true, true, authorities);
    }
}
