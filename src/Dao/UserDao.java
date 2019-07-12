package Dao;
import Bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private SqlBean sqlBean;

    private ResultSet rs;
    public User getLoginUser(User user){
        String uname = user.getuName();
        String pwd = user.getPwd();


        Connection conn = sqlBean.getConnection();
        String sql = "select * from user where uName =?and pwd=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,uname);
            ps.setString(2,pwd);

            rs = ps.executeQuery();
            while (rs.next()){
                User user2 = new User();
                user2.setuName(rs.getString(1));
                user2.setPwd(rs.getString(2));
                return user2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
