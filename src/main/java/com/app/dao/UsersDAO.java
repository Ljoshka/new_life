package com.app.dao;

import com.app.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsersDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void storeNewUser(Users users) {
        jdbcTemplate.update("INSERT INTO users (name, last_name, email, telephone_Number, adress, " +
                "country, postcode, delivery, cart_id, comments, internet_Bank, creditcard, password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", users.getName(), users.getLastName(), users.getEmail(), users.getTelephoneNumber(),
                users.getAddress(), users.getCountry(), users.getPostcode(), users.getDelivery(), users.getCart(), users.getComment(),
                users.getInternetBank(), users.getCreditCard(), users.getPassword());
    }

    public List<Users> getAllUsers() {
        RowMapper<Users> rowMapper = (rs, rowNumber) -> mapUser(rs);
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    public List<Users> getUserByEmail(String email) {
        RowMapper<Users> rowMapper = (rs, rowNumber) -> mapUser(rs);
        return jdbcTemplate.query("SELECT * FROM users WHERE email = ?", rowMapper, email);
    }

    private Users mapUser(ResultSet rs) throws SQLException {
        Users users = new Users();

        users.setId(rs.getLong("id"));
        users.setName(rs.getString("name"));
        users.setLastName(rs.getString("last_name"));
        users.setEmail(rs.getString("email"));
        users.setTelephoneNumber(rs.getString("telephone_number"));
        users.setAddress(rs.getString("adress"));
        users.setCountry(rs.getString("country"));
        users.setPostcode(rs.getString("postcode"));
        users.setDelivery(rs.getString("delivery"));
        users.setCart(rs.getString("cart_id"));
        users.setComment(rs.getString("comments"));
        users.setInternetBank(rs.getString("internet_bank"));
        users.setCreditCard(rs.getString("creditcard"));
        users.setPassword(rs.getString("password"));

        return users;
    }

}
