package com.controller;

/**
 * Created by rbc on 2018/12/5.
 */

import com.dao.UserJPA;
import com.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@RestController
//@CacheConfig(cacheNames = "user")
public class UserController {


    @Autowired
    private UserJPA userJPA;

//    @Cacheable
    //@Cacheable(cacheNames="users", condition="#result.name.length < 32")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }


    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity user){
        return userJPA.save(user);
    }

    @RequestMapping(value = "/add")
    public String add()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("测试");
        userEntity.setAddress("测试地址");
        userEntity.setAge(21);
        userJPA.save(userEntity);
        return "用户信息添加成功";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id)
    {
        userJPA.delete(id);
        return userJPA.findAll();
    }

    /**
     * 根据条件自定义编写删除SQL
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere()
    {
        userJPA.deleteQuery("admin","123456");
        return "自定义SQL删除数据成功";
    }

    /**
     * 分页查询测试
     * @param page 传入页码，从1开始
     * @return
     */

    @RequestMapping(value = "/curpage")
    public List<UserEntity> curPage(int page)
    {
        UserEntity user = new UserEntity();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC : Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction, user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage() - 1,user.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }


    @RequestMapping(value = "/curpage2")
        public void testPageQuery() throws Exception {
        int page=1,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        userJPA.findAll(pageable);
       // userRepository.findByUserName("testName", pageable);
    }

}

