package com.chaochao.ssm.service.impl;

import com.chaochao.ssm.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl {
    @Resource
    private UserDao ud;
    public UserDao getUd() { return ud; }
    public void setUd(UserDao ud) { this.ud = ud; }

}
