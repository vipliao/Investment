package com.firm.investment.news.service;

import java.util.List;

import com.firm.investment.base.service.IBaseService;
import com.firm.investment.news.entity.NewsEntity;
import com.firm.investment.news.vo.NewsVO;

public interface INewsService extends IBaseService<NewsEntity,NewsVO>{
	List<NewsVO> queryLaterNews(int actionType) throws Exception;
}
