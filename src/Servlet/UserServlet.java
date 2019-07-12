package Servlet;

import Bean.User;
import Service.UserService;
import Service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        userService = ac.getBean("UserService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("list",userService.show());
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }

}
