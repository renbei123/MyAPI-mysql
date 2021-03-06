package com.entity;


import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "CrsApi")
//Entity中不映射成列的字段得加@Transient 注解，不加注解也会映射成列
public class CrsApi
{

    @Id
    @Column(name = "id",unique = true,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "path",  nullable = false,  length = 800)
    private String path;

    @Column(name = "method", nullable = false, length = 10)
    private String method;

    @Column(name = "headers", length = 1000)
    private String headers;

    @Column(name = "body", length =10000)
    private String body;

    @Column(name = "var_name")
    private String var_name;

    @Column(name = "var_value", length =1000)
    private String var_value;

    @Column(name = "remarks")
    private String remarks;

    //取邮件@的前缀名字，避免中文重名
    @Column(name = "creater", length = 20)
    private String creater;

    @Column(name = "assert_Code")
    private Integer assert_Code;

    @Column(name = "exceptString", length =1000)
    private String exceptString;


    @Column(name = "status")
    private Boolean status=true;   // true: 使用中   false：废弃

    @Transient
    private String[] var_names=null;
    @Transient
    private String[] var_values=null;

    @Transient
    private String[] excepts=null;

}