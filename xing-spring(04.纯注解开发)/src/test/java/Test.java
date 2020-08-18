import com.xing.config.MyConfig;
import com.xing.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
//        纯注解 必须用这个对象， 而 xml应用对象用 ClassPathXMLApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        获取bean，@Bean的方法名就等于 Xml配置里的 bean的id
        String getStr = context.getBean("getStr", String.class);
        System.out.println(getStr);
//        获取自动装配的user,因为没xml配置文件，所以要在config里设置扫描包
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }
}
