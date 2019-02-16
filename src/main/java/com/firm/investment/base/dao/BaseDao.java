package com.firm.investment.base.dao;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.firm.investment.base.entity.BaseEntity;

@NoRepositoryBean
public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, Serializable>, JpaSpecificationExecutor<T> {
}