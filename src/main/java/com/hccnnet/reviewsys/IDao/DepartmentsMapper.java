package com.hccnnet.reviewsys.IDao;

import com.hccnnet.reviewsys.domain.Departments;

public interface DepartmentsMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Departments record);

    int insertSelective(Departments record);

    Departments selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Departments record);

    int updateByPrimaryKey(Departments record);
}