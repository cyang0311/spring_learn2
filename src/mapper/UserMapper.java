package mapper;

import Bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> selAll();

    @Select("select * from user where name=#{name} and pwd=#{pwd}")
    User selByPwd(User user);
}
