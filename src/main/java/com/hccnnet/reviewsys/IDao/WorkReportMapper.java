package com.hccnnet.reviewsys.IDao;

import com.hccnnet.reviewsys.domain.WorkReport;

public interface WorkReportMapper {
    int deleteByPrimaryKey(Integer wId);

    int insert(WorkReport record);

    int insertSelective(WorkReport record);

    WorkReport selectByPrimaryKey(Integer wId);

    int updateByPrimaryKeySelective(WorkReport record);

    int updateByPrimaryKey(WorkReport record);
}