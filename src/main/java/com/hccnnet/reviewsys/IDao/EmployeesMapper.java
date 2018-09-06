package com.hccnnet.reviewsys.IDao;

import com.hccnnet.reviewsys.domain.Employees;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesMapper {
    int deleteByPrimaryKey(Integer epId);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer epId);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);
}