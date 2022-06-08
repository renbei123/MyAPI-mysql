package com.controller;

/**
 * Created by rbc on 2018/12/5.
 */

import com.dao.ApiJPA;
import com.dao.ErrorLogJPA;
import com.dao.MonitorLogJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CacheConfig(cacheNames = "Statics")
public class StaticsController {


    @Autowired
    private ApiJPA apiJPA;
    @Autowired
    private ErrorLogJPA errorlogjpa;
    @Autowired
    private MonitorLogJPA monitorlogjpa;

    //@Cacheable
    //@Cacheable(cacheNames="users", condition="#result.name.length < 32")
    @RequestMapping(value = "/allapiSum",method = RequestMethod.GET)
    public String allApiSum(Model model) {
        long apisum = apiJPA.count();
        model.addAttribute("apisum", apisum);
        return "index";
    }





}

