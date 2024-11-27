package com.nexign.springDemo.dao;

import com.nexign.springDemo.model.Address;
import com.nexign.springDemo.model.User;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//@Component
public class UserDAO {
    private JdbcTemplate jdbcTemplate;
//    @Autowired
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


    public long addUser(User user) throws SQLException {
        Address address = user.getAddress();
        String city = address.getCity();
        String street = address.getStreet();

        Connection connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into users(city, street) values(?, ?)",
                                                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, city);
        preparedStatement.setString(2, street);
        preparedStatement.executeUpdate();
        preparedStatement.getGeneratedKeys().next();
        return preparedStatement.getGeneratedKeys().getLong(1);
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
