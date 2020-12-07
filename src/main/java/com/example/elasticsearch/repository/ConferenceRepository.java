package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:19
 */
public interface ConferenceRepository extends ElasticsearchRepository<Conference, String> {

  long countByName(String name);

  long deleteByName(String name);

  List<Conference> removeByName(String name);

  List<Conference> findByName(String name);

  List<Conference> findByNameIgnoreCase(String name);

  List<Conference> findByNameLike(String nameLike);

  List<Conference> findByAgeGreaterThan(String nameLike);

  List<Conference> findByAgeLessThan(String nameLike);

  List<Conference> findByAgeBetween(int age1, int age2);

  List<Conference> findByNameAndAgeOrderByDateAsc(String name, int age);

  List<Conference> findByNameAndAgeOrderByDateDesc(String name, int age);

}
