import Bean.User;
import Service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Spring+MyBatis测试
 */
public class client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

//        PeopleFactory pf = ac.getBean("fac",PeopleFactory.class);
//        System.out.println(pf.getInstance());
//
//        People p = ac.getBean("peo2",People.class);
//        System.out.println(p);

//        String[] names = ac.getBeanDefinitionNames();
//        for (String name:names) {
//            System.out.println(name);
//        }
        UserServiceImpl bean = ac.getBean("UserService",UserServiceImpl.class);
        List<User> list = bean.show();
        System.out.println(list);
    }
}
