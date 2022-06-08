package com.dao;

import com.entity.SystemVar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemVarJPA extends JpaRepository<SystemVar, Long> {

    public List findByCreaterOrderById(String creater);


}