package top.wushanghui.shardingjdbcdemo.entity;

import lombok.Data;

/**
 * @author wsh
 * @date 2021/3/21 10:15 下午
 */
@Data
public class Course {

    private Integer courseId;
    private String courseName;
    private Integer userId;
    private String status;
}
