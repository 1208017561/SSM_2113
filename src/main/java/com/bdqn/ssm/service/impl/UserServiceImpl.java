package com.bdqn.ssm.service.impl;
import com.bdqn.ssm.dao.UserDao;
import com.bdqn.ssm.entity.User;
import com.bdqn.ssm.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao ud;
    public UserDao getUd() {
        return ud;
    }
    public void setUd(UserDao ud) {
        this.ud = ud;
    }
    /**
     * 通过用户编码与密码查询用户记录
     * @param userCode
     * @param userPassword
     * @return
     */
    @Override
    public User getLoginUser(String userCode, String userPassword) {
        User user=ud.getLoginUser(userCode);
        if(user!=null){
           if(user.getUserPassword().equals(userPassword)){
               return user;
           }
        }
        return null;
    }
    @Override
    public List<User> getUserList(String userName, Integer userRole, Integer currentPageNo, Integer pageSize) {
        currentPageNo = (currentPageNo-1)*pageSize;
        return ud.getUserList(userName,userRole,currentPageNo,pageSize);
    }
    /**
     * 统计总记录数
     * @param userName
     * @param userRole
     * @return
     */
    @Override
    public int getUserCount(String userName, Integer userRole) {
        return ud.getUserCount(userName,userRole);
    }
    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Override
    public void add(User user) {
       ud.add(user);
    }
    /**
     * 通过用户编码查看用户是否存在
     * @param userCode
     * @return
     */
    @Override
    public User getUserExist(String userCode) {
        return ud.getLoginUser(userCode);
    }
    /**
     * 通过id查询用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserById(String userId) {
        return ud.getUserById(userId);
    }

    /**
     * 修改用户信息
     * @param user
     */
    @Override
    public void updateUser(User user) {
          ud.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        ud.deleteUser(id);
    }


}
