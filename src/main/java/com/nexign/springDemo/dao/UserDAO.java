package com.nexign.springDemo.dao;

import com.nexign.springDemo.model.Address;
import com.nexign.springDemo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
        jdbcTemplate.execute("""
                select * from users where id = ?
                """);
        return ;
    }

}
