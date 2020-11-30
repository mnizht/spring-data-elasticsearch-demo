package com.example.elasticsearch.repository.impl;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

/**
 * @author haitao zhu
 * @date 2020/11/27 15:42
 *
 * The class needs to have a constructor of the super class which the store-specific repository factory implementation uses.
 * If the repository base class has multiple constructors, override the one taking an EntityInformation plus a store
 * specific infrastructure object (such as an EntityManager or a template class).
 */
public class MyRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> {

  private final EntityManager entityManager;

  public MyRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
                          EntityManager entityManager) {
    super(entityInformation, entityManager);

    this.entityManager = entityManager;

  }

  @Transactional
  public <S extends T> S save(S entity){
    // 自定义方法
    return null;
  }
}
