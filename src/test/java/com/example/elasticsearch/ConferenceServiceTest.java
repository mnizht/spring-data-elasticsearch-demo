package com.example.elasticsearch;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/11/30 9:55
 */
public class ConferenceServiceTest extends RootTest {

  @Autowired
  private ConferenceService conferenceService;

  @Test
  public void findTest() {
    Page<Conference> page = conferenceService.getPage(0, 10);
    page.forEach(System.out::println);
  }

  @Test
  public void getListByNameTest() {
    String name = "remove";
    conferenceService.getListByName(name).forEach(System.out::println);
  }

  @Test
  public void saveOneTest() {
    Conference conference = Conference.builder()
      .id(null)
      .name("remove00059")
      .date("2020-12-07")
      .keywords(Arrays.asList("倒霉蛋", "罗翔", "三迟但到"))
      .location(new GeoPoint(52.5234051D, 13.4113999))
      .build();
    System.out.println("save one========");
    System.out.println(conferenceService.saveOne(conference));

  }

  @Test
  public void insertSomeData() {
    List<Conference> dataList = new ArrayList<>();

    dataList.add(Conference.builder().date("2014-11-06").name("Spring eXchange 2014 - London")
      .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    dataList.add(Conference.builder().date("2014-12-07").name("Scala eXchange 2014 - London")
      .keywords(Arrays.asList("scala", "play", "java")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    dataList.add(Conference.builder().date("2014-11-20").name("Elasticsearch 2014 - Berlin")
      .keywords(Arrays.asList("java", "elasticsearch", "kibana")).location(new GeoPoint(52.5234051D, 13.4113999))
      .build());
    dataList.add(Conference.builder().date("2014-11-12").name("AWS London 2014")
      .keywords(Arrays.asList("cloud", "aws")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    dataList.add(Conference.builder().date("2014-10-04").name("JDD14 - Cracow")
      .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(50.0646501D, 19.9449799)).build());

    conferenceService.insertDataSample(dataList).forEach(System.out::println);
  }

  @Test
  public void deleteByNameTest() {
    String name = "delete1";
    System.out.println(conferenceService.deleteByName(name));
  }

  @Test
  public void removeByNameTest() {
    conferenceService.removeByName("remove1").forEach(System.out::println);
  }

  @Test
  public void deleteAllTest() {
    conferenceService.deleteAll();
  }
}
