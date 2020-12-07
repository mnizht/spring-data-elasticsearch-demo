package com.example.elasticsearch;

import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/7 18:08
 */
public class PersonServiceTest extends RootTest {

  @Autowired
  private PersonService personService;

  @Test
  public void saveAllTest() {
    List<Person> persons = new ArrayList<>();
    persons.add(Person.builder().title("德玛西亚之力").name("盖伦").age(27).country("德玛西亚").gender((byte) 1)
      .wages(3150L).owned(true).keywords(Arrays.asList("重装战士", "三国猛将")).location(new GeoPoint(13.4141, 33.2333)).build());
    persons.add(Person.builder().title("寒冰射手").name("艾希").age(26).country("弗雷尔卓德").gender((byte) 0)
      .wages(3150L).owned(true).keywords(Arrays.asList("森林", "猎人")).location(new GeoPoint(11.441, 31.2333)).build());

    personService.saveAll(persons).forEach(System.out::println);
  }

  @Test
  public void getAllTest() {
    personService.getAll().forEach(System.out::println);
  }
}
