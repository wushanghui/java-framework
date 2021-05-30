# 课程数据库脚本
# course_db_1 课程1号库
CREATE DATABASE `course_db_1` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
use course_db_1;
DROP TABLE IF EXISTS `course_1`;
CREATE TABLE `course_1`
(
    `course_id`   bigint(20)                                             NOT NULL COMMENT '课程id',
    `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
    `user_id`     bigint(20)                                             NOT NULL COMMENT '课程所属用户id',
    `status`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程状态',
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `course_2`;
CREATE TABLE `course_2`
(
    `course_id`   bigint(20)                                             NOT NULL COMMENT '课程id',
    `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
    `user_id`     bigint(20)                                             NOT NULL COMMENT '课程所属用户id',
    `status`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程状态',
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

# course_db_2 课程2号库
CREATE DATABASE `course_db_2` CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
use course_db_2;
DROP TABLE IF EXISTS `course_1`;
CREATE TABLE `course_1`
(
    `course_id`   bigint(20)                                             NOT NULL COMMENT '课程id',
    `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
    `user_id`     bigint(20)                                             NOT NULL COMMENT '课程所属用户id',
    `status`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程状态',
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `course_2`;
CREATE TABLE `course_2`
(
    `course_id`   bigint(20)                                             NOT NULL COMMENT '课程id',
    `course_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
    `user_id`     bigint(20)                                             NOT NULL COMMENT '课程所属用户id',
    `status`      varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程状态',
    PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;