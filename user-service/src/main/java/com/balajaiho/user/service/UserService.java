package com.balajaiho.user.service;

import com.balajaiho.user.VO.Department;
import com.balajaiho.user.VO.ResponseTemplateVO;
import com.balajaiho.user.entity.User;
import com.balajaiho.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside the saveUser method of UserService");
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartmentId(Long userId) {
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject("http://localhost:9001/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
