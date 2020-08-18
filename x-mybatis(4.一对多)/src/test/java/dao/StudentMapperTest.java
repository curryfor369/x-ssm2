package dao;

import com.xing.dao.TeacherMapper;
import com.xing.pojo.Teacher;
import com.xing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class StudentMapperTest {
    @Test
    public void test1() {
        SqlSession sqlSession =
                MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacherStus = mapper.getTeacherStus(1);
        System.out.println(teacherStus);
        sqlSession.close();
    }
}
