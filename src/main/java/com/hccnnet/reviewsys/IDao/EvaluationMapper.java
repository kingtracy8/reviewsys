package com.hccnnet.reviewsys.IDao;

import com.hccnnet.reviewsys.domain.Evaluation;

public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer elId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer elId);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}