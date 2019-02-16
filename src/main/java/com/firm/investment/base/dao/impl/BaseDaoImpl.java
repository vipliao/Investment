package com.firm.investment.base.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.firm.investment.base.dao.BaseDao;
import com.firm.investment.base.entity.BaseEntity;
import com.firm.investment.base.entity.SuperEntity;

@Transactional
public class BaseDaoImpl<T extends BaseEntity> extends SimpleJpaRepository<T, Serializable> implements BaseDao<T> {
	private final EntityManager entityManager;

	public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
		this.entityManager = entityManager;
	}

	public BaseDaoImpl(JpaEntityInformation<T, Serializable> information, EntityManager entityManager) {
		super(information, entityManager);
		this.entityManager = entityManager;
	}

	public <S extends T> S save(S entity) {
		if (entity instanceof SuperEntity) {
			((SuperEntity) entity).setUpdateTime(new Timestamp(System.currentTimeMillis()));
		}
		return super.save(entity);
	}

	/*public void delete(T entity) {
		this.save(entity);
	}

	public void delete(Serializable id) {
		BaseEntity entity = (BaseEntity) this.findOne(id);
		this.save(entity);
	}*/
	
}