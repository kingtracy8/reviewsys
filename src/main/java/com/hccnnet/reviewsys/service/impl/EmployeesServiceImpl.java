package com.hccnnet.reviewsys.service.impl;

import com.hccnnet.reviewsys.IDao.EmployeesMapper;
import com.hccnnet.reviewsys.domain.Employees;
import com.hccnnet.reviewsys.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by trcay on 2018/9/6.
 */
@Service("employeesService")
public class EmployeesServiceImpl implements IEmployeesService{

    @Autowired
    EmployeesMapper employeesMapper;

    @Override
    public Employees selectByPrimaryKey(Integer epId) {
        return employeesMapper.selectByPrimaryKey(epId);
    }
}
