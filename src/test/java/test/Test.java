package test;

import com.bdqn.ssm.entity.User;
import com.bdqn.ssm.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    @org.junit.Test
    public void name() {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
        UserService us = (UserService) context.getBean("userService");
        List<User> userList=us.getUserList(" ",0,2,5);
       int count= us.getUserCount(null,null);
        System.out.println("大小"+userList.size());
        System.out.println("总记录数："+count);
    }
}
