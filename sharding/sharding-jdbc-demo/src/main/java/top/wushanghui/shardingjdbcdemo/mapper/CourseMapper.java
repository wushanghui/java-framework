package top.wushanghui.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.wushanghui.shardingjdbcdemo.entity.Course;

/**
 * @author wsh
 * @date 2021/3/21 10:17 下午
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {
}
