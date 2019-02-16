package com.firm.investment.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.firm.investment.base.dao.BaseQueryDao;
import com.firm.investment.base.service.impl.BaseServiceImpl;
import com.firm.investment.user.dao.UserDao;
import com.firm.investment.user.entity.UserEntity;
import com.firm.investment.user.service.IUserService;
import com.firm.investment.user.vo.UserVO;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserVO> implements IUserService {

	@Autowired
	private BaseQueryDao queryDao;
	@Autowired
	private UserDao dao;
	
	@Override
	public UserVO register(UserVO vo,int type) throws Exception {
		UserVO oldUser = queryUser(vo,type);
		if(oldUser !=null){
			throw new Exception("用户已注册！");
		}
		if(type == 0){
			vo.setType(0);
		}else if(type == 1){
			UserVO preUser = queryUser(vo,0);
			if(preUser ==null || preUser.getId() ==null || preUser.getId().equals("")){
				throw new Exception("用户不是待注册状态！");
			}
			vo.setType(1);
			vo.setId(preUser.getId());
			vo.setCreateTime(preUser.getCreateTime());
		}
		return save(vo, UserEntity.class, UserVO.class);
	}
	@Override
	public UserVO login(UserVO vo) throws Exception {
		if(vo == null){
			throw new Exception("没有登录信息");
		}
		if(vo.getPhone() == null || vo.getPhone().equals("")){
			throw new Exception("没有登录phone信息");
		}
		if(vo.getPassword() == null || vo.getPassword().equals("")){
			throw new Exception("没有登录password信息");
		}
		String sql = "select id,create_time createTime,update_time updateTime, phone,password,name,level_id levelId from invest_user where 1=1 and type=1 and phone='" + vo.getPhone()+ "' and password = '" + vo.getPassword() + "'";
		return (UserVO) queryDao.findOneBySql(sql, null, UserVO.class);
	}

	@Override
	public UserVO queryUserByPhone(String phone) throws Exception {
		String sql = "select id,create_time createTime,update_time updateTime, phone,password,name,level_id levelId from invest_user where 1=1 and phone='" + phone+"'";
		return (UserVO) queryDao.findOneBySql(sql, null, UserVO.class);
	}

	@Override
	@Transactional
	public void deleteByPhone(String phone) throws Exception {
		String sql = "delete from invest_user where phone = '"+phone+"'";
		queryDao.executeUpdateSQL(sql);
	}

	private UserVO queryUser(Object obj,int type) throws Exception{
		StringBuffer sql = new StringBuffer();
		sql.append("select id,create_time createTime,update_time updateTime,phone,password,name,level_id levelId,type from invest_user where 1=1 ");
		if(obj instanceof String){
			sql.append(" and phone='" + obj.toString()+"'");
		}else if(obj instanceof UserVO){
			sql.append(" and phone='" + ((UserVO)obj).getPhone()+"'");
		}
		if(type==1){
			sql.append(" and type=1");
		}
		Map<String,Object> map = new HashMap<>();
		List<UserVO> users = new ArrayList<UserVO>();
		users =	queryDao.findListBySql(sql.toString(), map, UserVO.class);
		if(users !=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	@Override
	public List<UserVO> queryUsersByType(int type) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select id,create_time createTime,update_time updateTime,phone,password,name,level_id levelId,type from invest_user where 1=1 ");
		if(type==1){
			sql.append(" and type=1");
		}else if(type ==0){
			sql.append(" and type=0");
		}
		Map<String,Object> map = new HashMap<>();
		List<UserVO> user = new ArrayList<UserVO>();
		user =	queryDao.findListBySql(sql.toString(), map, UserVO.class);
		return user;
	}
	
	@Override
	public List<UserVO> findAll(Class<UserVO> cls)
			throws IllegalAccessException, InvocationTargetException, InstantiationException {
		List<UserVO> reVos = new ArrayList<>();
		List<UserEntity> ens = dao.findAllOrder();
		if(ens != null && ens.size()>0){
			for(UserEntity en:ens){
				UserVO vo = new UserVO();
				BeanUtils.copyProperties(en, vo);
				reVos.add(vo);
			}
			
		}
		return reVos;
	}

}
