package com.service;

import com.dao.SystemVarJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemVar_redis {

//    private final static org.slf4j.Logger logger = LoggerFactory.getLogger("SystemVar_redis");

    @Autowired
    private SystemVarJPA systemvarjpa;


}
