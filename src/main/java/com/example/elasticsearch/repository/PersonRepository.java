package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:38
 */
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
  List<Person> findByProvinceAndCity(String province, String city);


  /**
   * @param name 看起来效果是分词查询。只要name字段中全包含了参数name的所有汉字（不论顺序是否一样），都可以查出来。
   *             但是英文有点特别。按单次分词的话，需要参数name是个完整的词
   * @return
   */
  List<Person> findByName(String name);

  @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
  List<Person> findByNameCustom(String name);


  List<Person> findByNameLike(String name);

  @Query("{ \"bool\" : { \"must\" : [ { \"query\" : \"?0\", \"fields\" : [ \"name\" ] }, \"analyze_wildcard\": false } ]  }")
  List<Person> findByNameLikeCustom(String name);


  /**
   * @return 使用Java 8 Stream <T>作为返回类型来逐步处理查询方法的结果。并非将查询结果包装在Stream中，而是使用特定于数据存储的方法来执行流传输
   */
  @Query("select p from Person p")
  Stream<Person> findAllByCustomQueryAndStream();
}
