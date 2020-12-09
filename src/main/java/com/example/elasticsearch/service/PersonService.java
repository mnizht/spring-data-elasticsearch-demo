package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:47
 */
@Service
public class PersonService {

  private static final Logger log = LoggerFactory.getLogger(PersonService.class);

  @Autowired
  private PersonRepository personRepository;

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

  public Iterable<Person> getAll() {
    return personRepository.findAll();
  }
  // endregion
}
