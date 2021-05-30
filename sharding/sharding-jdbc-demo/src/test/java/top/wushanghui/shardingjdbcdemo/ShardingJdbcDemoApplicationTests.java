package top.wushanghui.shardingjdbcdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.wushanghui.shardingjdbcdemo.entity.Course;
import top.wushanghui.shardingjdbcdemo.mapper.CourseMapper;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    @Autowired
    CourseMapper courseMapper;

    @Test
    void insertCourse() {
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setCourseName("Java");
            course.setUserId(1);
            course.setStatus("已发布");
            courseMapper.insert(course);
        }
    }

}
