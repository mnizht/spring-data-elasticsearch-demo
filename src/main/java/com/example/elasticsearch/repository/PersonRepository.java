package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:38
 */
public interface PersonRepository extends ElasticsearchRepository<Person,String> {
}
