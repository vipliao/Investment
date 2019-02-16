package com.firm.investment.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.user.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity>{

	@Query(value="select * from invest_user order by type,create_time desc",nativeQuery = true)
	List<UserEntity> findAllOrder();
}
