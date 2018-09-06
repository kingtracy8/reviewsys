package com.hccnnet.reviewsys.service;

import com.hccnnet.reviewsys.domain.Employees;

/**
 * Created by trcay on 2018/9/6.
 */
public interface IEmployeesService {

    public Employees selectByPrimaryKey(Integer epId);

}
