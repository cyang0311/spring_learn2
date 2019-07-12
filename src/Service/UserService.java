package Service;
import Bean.User;
import Dao.UserDao;

import java.util.List;

public interface UserService {
    List<User> show();

    User login(User user);
}
