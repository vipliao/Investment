package com.firm.investment.news.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firm.investment.assessory.vo.AssessoryVO;
import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.news.dao.NewsDao;
import com.firm.investment.news.entity.NewsEntity;
import com.firm.investment.news.service.INewsService;
import com.firm.investment.news.vo.NewsVO;

@Service
public class NewsServiceimpl  extends BaseServiceImpl<NewsEntity, NewsVO> implements INewsService{
	@Autowired
	private BaseQueryDao queryDao;
	
	@Autowired
	private NewsDao dao;
	
	public List<NewsVO> queryLaterNews(int actionType) throws Exception{
		List<NewsVO> newsList = new ArrayList<>();
		List<NewsEntity> ens = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		
		if(actionType==1){
			ens = dao.findNews();
		}else if(actionType==2){
			ens = dao.findInvest();
		}
		if(ens ==null || ens.size()<=0){
			return null;
		}

		for (NewsEntity en : ens) {
			NewsVO vo = new NewsVO();
			BeanUtils.copyProperties(en, vo);
			ids.add(en.getId());
			newsList.add(vo);
		}
		String sql = "select name,is_image isImage,path,type,business_id businessId,id,create_time createTime,update_time updateTime from invest_assessory where business_id in (:ids)";
		Map<String,Object> map = new HashMap<>();
		map.put("ids", ids);
		List<AssessoryVO> assessorys = queryDao.findListBySql(sql, map,AssessoryVO.class);
		if(assessorys !=null && assessorys.size()>0){
			for(NewsVO vo : newsList){
				List<AssessoryVO> newsAssessoryVO = new ArrayList<>();
				for(AssessoryVO assessoryVO:assessorys){
					if(assessoryVO.getBusinessId() !=null && !assessoryVO.getBusinessId().equals("") && assessoryVO.getBusinessId().equals(vo.getId())){
						newsAssessoryVO.add(assessoryVO);
					}
				}
				vo.setAssessorys(newsAssessoryVO);
			}
		}
		return newsList;
	}
	
	@Override
	@Transactional
	public NewsVO save(NewsVO vo, Class<NewsEntity> clazzE, Class<NewsVO> clazzV) throws Exception {
		NewsVO reVo = super.save(vo, clazzE, clazzV);
		if (vo.getAssessorys() != null && vo.getAssessorys().size() > 0) {
			List<String> delAIds= new ArrayList<>();
			List<String> addAIds = new ArrayList<>();
			for(AssessoryVO avo:vo.getAssessorys()){
				if(avo.getDelFlag()==1){
					delAIds.add(avo.getId());
				}else{
					addAIds.add(avo.getId());
				}
			}
			if(delAIds !=null && delAIds.size()>0){
				String idList = delAIds.toString().replaceAll(" ", "").replaceAll("\\,", "\\'\\,\\'")
						.replaceAll("\\[", "\\('").replaceAll("\\]", "\\')");
				String sql ="delete from invest_assessory where id in "+idList;
				queryDao.executeUpdateSQL(sql);
			}
			if(addAIds !=null && addAIds.size()>0){
				String idList = addAIds.toString().replaceAll(" ", "").replaceAll("\\,", "\\'\\,\\'")
						.replaceAll("\\[", "\\('").replaceAll("\\]", "\\')");
				String sql ="update  invest_assessory set business_id='"+reVo.getId()+"' where id in "+idList;
				queryDao.executeUpdateSQL(sql);
			}
		}
		reVo.setAssessorys(vo.getAssessorys());
		return reVo;
	}
	
	

}
