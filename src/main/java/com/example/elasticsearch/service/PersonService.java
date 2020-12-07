package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:47
 */
@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  // region create

  public Iterable<Person> saveAll(List<Person> persons) {
    return personRepository.saveAll(persons);
  }
  // endregion

  // region read

  public Iterable<Person> getAll() {
    return personRepository.findAll();
  }
  // endregion
}
