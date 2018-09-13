package com.hccnnet.reviewsys.IDao;

import com.hccnnet.reviewsys.domain.WorkReport;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkReportMapper {
    int deleteByPrimaryKey(Integer wId);

    int insert(WorkReport record);

    int insertSelective(WorkReport record);

    WorkReport selectByPrimaryKey(Integer wId);

    int updateByPrimaryKeySelective(WorkReport record);

    int updateByPrimaryKey(WorkReport record);

    Integer selectCommitDuplicate(int employeeId,int deptId);
}