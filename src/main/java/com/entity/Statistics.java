package com.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Statistics")
//Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列
public class Statistics
{

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "planId")
    private Long planId;

    @Column(name = "apiId")
    private Long apiId;



}