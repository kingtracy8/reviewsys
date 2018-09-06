package com.tracy.test;

import com.alibaba.fastjson.JSON;
import com.hccnnet.reviewsys.domain.Employees;
import com.hccnnet.reviewsys.service.IEmployeesService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by trcay on 2018/9/6.
 */


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMb {

    private static Logger logger = Logger.getLogger(TestMb.class);

    @Autowired
    IEmployeesService iEmployeesService;

    @Test
    public void test(){

        Employees employees = iEmployeesService.selectByPrimaryKey(1);

        logger.info(JSON.toJSONString(employees));

    }


}
