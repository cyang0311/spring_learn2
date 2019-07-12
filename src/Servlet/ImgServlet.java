package Servlet;

import Bean.User;
import Service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@WebServlet("/imgCode")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取响应流,输出图片流
//        ServletOutputStream os = resp.getOutputStream();
//        InputStream is = new FileInputStream(new File(getServletContext().getRealPath("images"),"a.jpg"));
//        int index = -1;
//        while ((index=is.read())!=-1){
//            os.write(index);
//        }


        //创建一张图片
        BufferedImage image = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);

        //透明玻璃
        Graphics2D gra = image.createGraphics();
        gra.setColor(Color.LIGHT_GRAY);
        //填充矩形区域
        gra.fillRect(0,0,100,50);

        List<Integer> randList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randList.add(random.nextInt(10));
        }
        //随机数
        Color[] colors = new Color[]{Color.RED,Color.CYAN,Color.PINK,Color.orange,Color.black,Color.MAGENTA};
        gra.setFont(new Font("楷书",Font.BOLD|Font.ITALIC,26));
        for (int i = 0; i < randList.size(); i++) {
            gra.setColor(colors[random.nextInt(colors.length)]);
            gra.drawString(randList.get(i)+"",i*20+15,28+random.nextInt(21)-10);
        }
        //划线
        for (int i = 0; i < 2; i++) {
            gra.setColor(colors[random.nextInt(colors.length)]);
            gra.drawLine(0,random.nextInt(50),100,random.nextInt(50));
        }

        ServletOutputStream outputStream = resp.getOutputStream();
        //工具类
        ImageIO.write(image,"jpg",outputStream);

        HttpSession session = req.getSession();
        session.setAttribute("code",""+randList.get(0)+randList.get(1)+randList.get(2)+randList.get(3));
    }
}
