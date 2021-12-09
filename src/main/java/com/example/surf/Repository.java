package com.example.surf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@org.springframework.stereotype.Repository

public class Repository {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


}
