package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.UncategorizedElasticsearchException;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:47
 */
@Service
public class PersonService {

  private static final Logger log = LoggerFactory.getLogger(PersonService.class);

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

  /**
   * @param name 姓名
   * @return 模糊匹配人名
   */
  public List<Person> getByNameLike(String name) {
    return personRepository.findByNameLike(name);
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
