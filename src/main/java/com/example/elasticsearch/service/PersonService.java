package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.param.PersonSearchParam;
import com.example.elasticsearch.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.UncategorizedElasticsearchException;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:47
 */
@Service
public class PersonService {

  private static final Logger log = LoggerFactory.getLogger(PersonService.class);
  private final IndexCoordinates index = IndexCoordinates.of("person");


  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private ElasticsearchOperations operations;

  // region create

  public Iterable<Person> saveAll(List<Person> persons) {
    if (Objects.isNull(persons) || persons.isEmpty()) {
      log.debug("insert person data list is null or empty");
      return null;
    }
    log.info("insert person data list size = {}", persons.size());
    return personRepository.saveAll(persons);
  }

  public void initData() {

  }
  // endregion

  // region read

  /**
   * @return 查询索引内全部数据. 默认情况下，数据量大于10000时 elasticsearch会报错
   * @throws UncategorizedElasticsearchException reason=Result window is too large, from + size must be less than or equal to: [10000] but was
   *                                             See the scroll api for a more efficient way to request large data sets. This limit can be set by changing the [index.max_result_window] index level setting.
   */
  public Iterable<Person> getAll() {
    return personRepository.findAll();
  }

  public Optional<Person> getById(String id) {
    return personRepository.findById(id);
  }

  /**
   * @param province
   * @param city
   * @return
   */
  public List<Person> getByProvinceAndCity(String province, String city) {
    return personRepository.findByProvinceAndCity(province, city);
  }

  public List<Person> getByName(String name) {
    return personRepository.findByName(name);
  }

  public List<Person> getByNameCustom(String name) {
    return personRepository.findByNameCustom(name);
  }

  /**
   * @param name 姓名
   * @return 模糊匹配人名
   */
  public List<Person> getByNameLike(String name) {
    return personRepository.findByNameLike(name);
  }

  /**
   * 自定义姓名匹配
   *
   * @param name 姓名
   * @return 模糊匹配人名
   */
  public List<Person> getByNameLikeCustom(String name) {
    return personRepository.findByNameLikeCustom(name);
  }

  /**
   * Stream可能包装了特定于底层数据存储的资源，因此必须在使用后关闭。您可以使用close（）方法或使用Java 7 try-with-resources块来手动关闭Stream
   */
  public void findAllByCustomQuery() {
    Stream<Person> stream1 = personRepository.findAllByCustomQueryAndStream();
    stream1.forEach(System.out::println);
    stream1.close();

    try (Stream<Person> stream2 = personRepository.findAllByCustomQueryAndStream()) {
      stream2.forEach(System.out::println);
    }
  }

  /**
   * 单条件搜索
   *
   * @param param
   * @return SearchHits<Person>
   */
  public SearchHits<Person> searchUseCriteria(PersonSearchParam param) {
    Criteria criteria = new Criteria("name").is(param.getName());
    Query query = new CriteriaQuery(criteria);
    return operations.search(query, Person.class);

  }

  /**
   * 多条件搜索。相当于每个条件都单独搜索一次，返回多次搜索结果的集合
   *
   * @param param
   * @return List<SearchHits < Person>>
   */
  public List<SearchHits<Person>> searchUseMultiCriteria(PersonSearchParam param) {
    List<Query> queries = new ArrayList<>();
    queries.add(new CriteriaQuery(new Criteria("name").is(param.getName())));
    queries.add(new CriteriaQuery(new Criteria("phone").is(param.getPhone())));

    return operations.multiSearch(queries, Person.class);

  }

  /**
   * 多条件组合搜索。。还没 看懂它的逻辑
   *
   * @param criteria
   * @return List<SearchHits < Person>>
   */
  public SearchHits<Person> searchUseCriteria2(Criteria criteria) {

    CriteriaQuery query = new CriteriaQuery(criteria);
    return operations.search(query, Person.class, index);

  }

  // endregion

  // region delete

  public void deleteAll() {
    personRepository.deleteAll();
    operations.indexOps(Person.class).refresh();
  }


  /**
   * 删除索引，使用spring-data-elasticsearch 时，如果实体字段类型发生改变，需要比较改变后的类型是否会与es中的类型冲突，如果冲突，就要先删掉索引 indices 。否则再插入数据会报错
   *
   * @return 删除索引，返回是否成功
   */
  public Boolean deleteIndex() {
    return operations.indexOps(Person.class).delete();
  }
  // endregion
}
