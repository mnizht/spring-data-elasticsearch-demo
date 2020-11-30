package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * @author haitao zhu
 * @date 2020/11/27 16:31
 */
public interface ConferenceRepositoryQuerydslPredicate extends CrudRepository<Conference,String>, QuerydslPredicateExecutor<Conference> {

}
