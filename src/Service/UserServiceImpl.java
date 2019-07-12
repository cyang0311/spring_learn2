package Service;

import Bean.User;
import mapper.UserMapper;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Override
    public List<User> show() {
        return userMapper.selAll();
    }

    @Override
    public User login(User user) {
        return userMapper.selByPwd(user);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
