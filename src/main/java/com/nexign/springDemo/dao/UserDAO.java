package com.nexign.springDemo.dao;

import com.nexign.springDemo.model.Address;
import com.nexign.springDemo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class UserDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("""
                create table if not exists 
                users(id int auto_increment primary key,
                city varchar(255),
                street varchar(255))
            """);
    }

    public int addUser(User user) {
        Address address = user.getAddress();
        String city = address.city();
        String street = address.street();

        int update = jdbcTemplate.update("insert into users(city, street) values(?, ?)",
                city, street);

        return update;
    }

    public User getUser(int id) {
        String sql = "select * from users where id = " + id;
        RowMapper<User> rowMapper = (rs, rowNum) -> {
            Address address = new Address(rs.getString("city"), rs.getString("street"));
            return new User(rs.getInt("id"), address);
        };
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

}
