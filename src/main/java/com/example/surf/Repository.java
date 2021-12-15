package com.example.surf;

import com.example.surf.DTOs.BookingInformation;
import com.example.surf.DTOs.CreateUserRequest;
import com.example.surf.DTOs.Styles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository

public class Repository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Styles> getStyles() {
        String sql = "SELECT * FROM surf_style";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new StylesRowMapper());
    }

    public void bookSingleClient(BookingInformation bookingInformation) {
        String sql = "INSERT INTO surf_client(booking_id, date, time, surf_style, first_name, last_name, level, require_wetsuit,gender, weight, height, email )" +
                " VALUES (:booking_id, :date, :time, :surf_style, :first_name, :last_name, :level, :require_wetsuit, :gender, :weight, :height, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("booking_id", bookingInformation.getBookingId());
        paramMap.put("date", bookingInformation.getDate());
        paramMap.put("time", bookingInformation.getTime());
        paramMap.put("surf_style", bookingInformation.getSurfStyle());
        paramMap.put("first_name", bookingInformation.getFirstName());
        paramMap.put("last_name", bookingInformation.getLastName());
        paramMap.put("level", bookingInformation.getLevel());
        paramMap.put("require_wetsuit", bookingInformation.isWetsuit());
        paramMap.put("gender", bookingInformation.getGender());
        paramMap.put("weight", bookingInformation.getWeight());
        paramMap.put("height", bookingInformation.getHeight());
        paramMap.put("email", bookingInformation.getEmail());

        jdbcTemplate.update(sql, paramMap);
    }

    public List<BookingInformation> getAllClients() {
        String sql = "SELECT * FROM surf_client";
        Map<String, Object> paramMap = new HashMap<>();

        return jdbcTemplate.query(sql, paramMap, new BookingInformationRowMapper());
    }

    public void createAdminUser(String userName, String encodedPassword) {
        String sql = "INSERT INTO admin_user(user_name, password) VALUES (:userName, :password)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        paramMap.put("password", encodedPassword);
        jdbcTemplate.update(sql, paramMap);
    }

    public String adminLogin(String userName) {
        String sql = "SELECT password FROM admin_user WHERE user_name =:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    private class StylesRowMapper implements RowMapper<Styles> {
        public Styles mapRow(ResultSet resultSet, int i) throws SQLException {
            Styles styles = new Styles();
            styles.setId(resultSet.getInt("id"));
            styles.setStyle(resultSet.getString("surf_style"));
            styles.setPrice(resultSet.getInt("price"));
            return styles;
        }
    }

    private class BookingInformationRowMapper implements RowMapper<BookingInformation> {
        public BookingInformation mapRow(ResultSet resultSet, int i) throws SQLException {
            BookingInformation client = new BookingInformation();
            client.setBookingId(resultSet.getInt("booking_id"));
            client.setDate(resultSet.getDate("date"));
            client.setTime(resultSet.getTime("time"));
            client.setSurfStyle(resultSet.getInt("surf_style"));
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_name"));
            client.setLevel(resultSet.getString("level"));
            client.setWetsuit(resultSet.getBoolean("require_wetsuit"));
            client.setGender(resultSet.getString("gender"));
            client.setWeight(resultSet.getInt("weight"));
            client.setHeight(resultSet.getInt("height"));
            client.setEmail(resultSet.getString("email"));

            return client;
        }
    }

    public int deleteClient(int clientId) {
        String sql = "DELETE FROM surf_client WHERE client_id = :clientId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientId", clientId);

        return jdbcTemplate.update(sql, paramMap);
    }

    public BookingInformation editClient(int clientId, BookingInformation client) {
        String sql = "UPDATE surf_client SET booking_id = :bookingId, date = :date, time = :time, " +
                "surf_style = :surfStyle, first_name = :firstName, last_name = :lastName, " +
                "level = :level, require_wetsuit = :wetsuit, gender = :gender, weight = :weight, " +
                "height = :height, email = :email, client_id = :clientId WHERE client_id = :clientId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("clientId", clientId);
        paramMap.put("bookingId", client.getBookingId());
        paramMap.put("date", client.getDate());
        paramMap.put("time", client.getTime());
        paramMap.put("surfStyle", client.getSurfStyle());
        paramMap.put("firstName", client.getFirstName());
        paramMap.put("lastName", client.getLastName());
        paramMap.put("level", client.getLevel());
        paramMap.put("wetsuit", client.isWetsuit());
        paramMap.put("gender", client.getGender());
        paramMap.put("weight", client.getWeight());
        paramMap.put("height", client.getHeight());
        paramMap.put("email", client.getEmail());
        jdbcTemplate.update(sql, paramMap);

        return client;
    }

    public void bookGroup(BookingInformation bookingInformation) {
        String sql = "INSERT INTO surf_client(booking_id, date, time, surf_style, first_name, last_name, level, require_wetsuit,gender, weight, height, email )" +
                " VALUES (:booking_id, :date, :time, :surf_style, :first_name, :last_name, :level, :require_wetsuit, :gender, :weight, :height, :email)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("booking_id", bookingInformation.getBookingId());
        paramMap.put("date", bookingInformation.getDate());
        paramMap.put("time", bookingInformation.getTime());
        paramMap.put("surf_style", bookingInformation.getSurfStyle());
        paramMap.put("first_name", bookingInformation.getFirstName());
        paramMap.put("last_name", bookingInformation.getLastName());
        paramMap.put("level", bookingInformation.getLevel());
        paramMap.put("require_wetsuit", bookingInformation.isWetsuit());
        paramMap.put("gender", bookingInformation.getGender());
        paramMap.put("weight", bookingInformation.getWeight());
        paramMap.put("height", bookingInformation.getHeight());
        paramMap.put("email", bookingInformation.getEmail());

        jdbcTemplate.update(sql, paramMap);
    }

}
