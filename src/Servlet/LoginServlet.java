package Servlet;

import Bean.User;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = ac.getBean("UserService",UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");
        String codeSession = req.getSession().getAttribute("code").toString();
        if (codeSession.equals(code)){
            String uname = req.getParameter("uname");
            String pwd = req.getParameter("pwd");
            User userLogin = new User();
            userLogin.setuName(uname);
            userLogin.setPwd(pwd);
            User user = userService.login(userLogin);

            if (user!=null){
                resp.sendRedirect("/user");
            }else {
                req.setAttribute("error","账号密码错误");
                req.getRequestDispatcher("ValidCode.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("error","验证码错误");
            req.getRequestDispatcher("ValidCode.jsp").forward(req,resp);
        }
    }
}
