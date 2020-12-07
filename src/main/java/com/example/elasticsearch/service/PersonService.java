package com.example.elasticsearch.service;

import com.example.elasticsearch.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:47
 */
@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;
}
