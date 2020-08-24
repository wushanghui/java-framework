package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wsh
 * @date 2020-08-21 14:28
 */
@Service
public class ConsumeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


}
