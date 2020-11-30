package com.example.elasticsearch;

import com.example.elasticsearch.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author haitao zhu
 * @date 2020/11/30 9:55
 */
public class ConferenceServiceTest extends RootTest {

  @Autowired
  private ConferenceService conferenceService;

  @Test
  public void insertDataTest() {
    conferenceService.insertDataSample();
  }

  @Test
  public void getAllTest() {
    System.out.println("======================");
    conferenceService.getAll().forEach(System.out::println);
    System.out.println("======================");
  }
}
