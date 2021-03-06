package com.dao;


import com.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface UserJPA extends
        JpaRepository<UserEntity, Long> ,
        JpaSpecificationExecutor<UserEntity> ,
        Serializable {
    /*
     * 通过地址进行查询，参数为address,
     * 相当于JPQL：select p from Person p where p.address=?1
     * */
    List<UserEntity> findByAddress(String address);

    /*
     * 通过地址和名字进行查询，参数为name,address
     * 相当于JPQL：select p from Person p where p.name=?1 and address=?2
     * */
    UserEntity findByNameAndPwd(String name,String pwd);

   /* 从代码可以看出，使用findBy,And这样的关键字，其中的findBy可以用find,getBy,query,read来进行代替。
    而And就相当于sql语句中的and
    关键字限制结果数量，用top和first来实现
    */

    /*
     *查询符合条件的前十条记录
     */
    List<UserEntity> findFirst10ByName(String name);
    /*
     *查询符合条件的前30条记录
     */
    List<UserEntity> findTop30ByName(String name);


    @Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    //根据用户名、密码删除一条数据
    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);
}



