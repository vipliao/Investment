package com.firm.investment.news.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.news.entity.NewsEntity;

public interface NewsDao extends BaseDao<NewsEntity>{
	@Query(value="select * from invest_news where type <> 5",nativeQuery=true)
	List<NewsEntity> findNews();
	
	@Query(value="select * from invest_news where type = 5",nativeQuery=true)
	List<NewsEntity> findInvest();
}
