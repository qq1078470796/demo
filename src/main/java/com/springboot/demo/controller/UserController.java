package com.springboot.demo.controller;

import com.springboot.demo.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api(value = "用户模块",description = "用户模块的接口")
@RestController
public class UserController {
    public static List<User> users = new ArrayList<User>();
    static{
        users.add(new User("zhangsan","123123"));
        users.add(new User("lisi","123123"));
    }

    @ApiOperation(value = "获取用户列表",notes = "获取所有用户的信息")
    @ResponseBody
    @GetMapping("/users")
    public Object index(){
        HashMap<String, List> map = new HashMap<>();
        map.put("users",users);
        return users;
    }
    @ApiOperation(value = "根据id查询用户",notes = "查询单个用户的值")
    @ApiImplicitParam(name = "id",value = "userid",dataType = "int",paramType = "path")
    @ResponseBody
    @GetMapping("/users/{id}")
    public Object getUserById(@PathVariable("id") String id){
        int uid = Integer.parseInt(id);
        return users.get(uid);
    }

    @ApiOperation(value = "添加用户用户")
    @ApiImplicitParam(value = "用户类")
    @ResponseBody
    @GetMapping("/user")
    public Object add(User user){
        System.out.println(user);
        return users.add(user);
    }

}
