package com.example.elasticsearch;

import com.example.elasticsearch.dto.PersonCountDTO;
import com.example.elasticsearch.entity.Person;
import com.example.elasticsearch.param.PersonSearchParam;
import com.example.elasticsearch.service.InItDataService;
import com.example.elasticsearch.service.PersonService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;

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
  private InItDataService inItDataService;

  @Test
  public void saveAllTest() {

  }

  @Test
  public void getAllTest() {
    personService.getAll().forEach(System.out::println);
  }

  @Test
  public void getTest() {
    String id = "6666515670085275648";
    String province = "6699567226359517184";
    String city = "6699567233347227648";
    System.out.println("============================= Part 1 =================================");
    personService.getByProvinceAndCity(province, city).forEach(System.out::println);

    System.out.println("============================= Part 2 =================================");
    personService.getById(id).ifPresentOrElse(System.out::println, () -> log.error("id is error"));

//    String name = "张宏亦";
//    List<Person> personList = personService.getByName(name);
//    List<Person> personList1 = personService.getByNameCustom(name);
////    List<Person> personList2 = personService.getByNameLike(name);
////    List<Person> personList3 = personService.getByNameLike(name);
//    System.out.println("=========================== 1 num: " + personList.size());
//    personList.forEach(System.out::println);
//    System.out.println("=========================== 2 num: " + personList1.size());
//
//    personList1.forEach(System.out::println);
  }

  @Test
  public void getCustomTest() {
    String name = "家长";
//    List<Person> personList = personService.getByNameLikeCustom(name);
    List<Person> personList = personService.getByName(name);
    System.out.println("num: " + personList.size());
    personList.forEach(System.out::println);
  }

  @Test
  public void findAllCustomQueryTest() {
    personService.findAllByCustomQuery();
  }

  @Test
  public void getFamilyCountTest() {
    System.out.println("=============== Count ==============");
    inItDataService.getFamilyCount().forEach(System.out::println);
    System.out.println("=============== Count ==============");

  }

  @Test
  public void getFamilyTest() {
    List<PersonCountDTO> personCountDTOS = inItDataService.getFamilyCount().subList(0, 10);
    int size = 1000;
    for (PersonCountDTO dto : personCountDTOS) {
      long maxPage = dto.getNum() / size;
      for (int page = 0; page < maxPage + 1; page++) {
        List<Person> persons = inItDataService.getPerson(dto.getOrgId(), page, size);
        if (!persons.isEmpty()) {
          Iterable<Person> people = personService.saveAll(persons);
          log.info("insert people: {}", people.spliterator().estimateSize());

        }
      }
    }
  }

  @Test
  public void getUseCriteriaTest() {
    PersonSearchParam param = new PersonSearchParam().setName("海涛").setPhone("157");
    SearchHits<Person> searchHits = personService.searchUseCriteria(param);
    System.out.println(searchHits.toString());
    searchHits.stream().forEach(System.out::println);
  }

  @Test
  public void getUseMultiCriteriaTest() {
    PersonSearchParam param = new PersonSearchParam().setName("海涛").setPhone("13612341111");
    List<SearchHits<Person>> searchHits = personService.searchUseMultiCriteria(param);
    System.out.println(searchHits.toString());
    searchHits.forEach(hit -> hit.forEach(System.out::println));
  }

  @Test
  public void getUseCriteria2Test() {
    PersonSearchParam param = new PersonSearchParam().setName("海涛").setPhone("1573731");
    SearchHits<Person> searchHits = personService.searchUseCriteria2(param);
    System.out.println(searchHits.toString());
    searchHits.forEach(System.out::println);

  }

  @Test
  public void deleteTest() {
    personService.deleteAll();
  }

  @Test
  public void deleteIndex() {
    System.out.println("删除成功：" + personService.deleteIndex());
  }
}
