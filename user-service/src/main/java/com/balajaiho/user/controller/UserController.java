package com.balajaiho.user.controller;

import com.balajaiho.user.VO.ResponseTemplateVO;
import com.balajaiho.user.entity.User;
import com.balajaiho.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside the saveUser method of UserController");
        return userService.saveUser(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartmentId(@PathVariable("id") Long userId){
        return userService.getUserWithDepartmentId(userId);
    }
}
