package com.firm.investment.interest.dao;

import java.util.List;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.interest.entity.InterestEntity;

public interface InterestDao extends BaseDao<InterestEntity>{

	List<InterestEntity> findByUserId(String userId);
}
