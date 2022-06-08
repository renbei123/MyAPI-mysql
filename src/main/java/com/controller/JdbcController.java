package com.controller;

/**
 * Created by rbc on 2018/12/5.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {


    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    public JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/jdbc", method = RequestMethod.GET)
    public List<Map<String, Object>> queryUsers() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from chapter ");
        return list;
    }

}

