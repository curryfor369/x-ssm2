import com.xing.mapper.UserMapper;
import com.xing.mapper.UserMapperImpl;
import com.xing.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UserTest {

    public void test1() throws IOException {
        // 测试mybatis
        String classpath = "mybatis-config.xml";
        InputStream ins = Resources.getResourceAsStream(classpath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapperImpl userMapperImpl = con.getBean("userMapperImpl", UserMapperImpl.class);
        List<User> users = userMapperImpl.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
