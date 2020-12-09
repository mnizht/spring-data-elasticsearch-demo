package com.example.elasticsearch;

import com.example.elasticsearch.dto.PersonCountDTO;
import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.service.InItPersonService;
import com.example.elasticsearch.service.PersonService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/7 18:08
 */
public class PersonServiceTest extends RootTest {

  private static final Logger log = LoggerFactory.getLogger(PersonServiceTest.class);

  @Autowired
  private PersonService personService;
  @Autowired
  private InItPersonService inItPersonService;

  @Test
  public void saveAllTest() {

  }

  @Test
  public void getAllTest() {
    personService.getAll().forEach(System.out::println);
  }

  @Test
  public void getFamilyCountTest() {
    System.out.println("=============== Count ==============");
    inItPersonService.getFamilyCount().forEach(System.out::println);
    System.out.println("=============== Count ==============");

  }

  @Test
  public void getFamilyTest() {
    List<PersonCountDTO> personCountDTOS = inItPersonService.getFamilyCount().subList(0, 10);
    int size = 1000;
    for (PersonCountDTO dto : personCountDTOS) {
      long maxPage = dto.getNum() / size;
      for (int page = 0; page < maxPage + 1; page++) {
        List<Person> persons = inItPersonService.getPerson(dto.getOrgId(), page, size);
        if (!persons.isEmpty()) {
          Iterable<Person> people = personService.saveAll(persons);
          log.info("insert people: {}", people.spliterator().estimateSize());

        }
      }
    }
  }
}
