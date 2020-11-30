package com.example.elasticsearch;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.function.Function;

/**
 * @author haitao zhu
 * @date 2020/11/30 9:55
 */
public class ConferenceServiceTest  extends RootTest {

  @Autowired
  private ConferenceService conferenceService;

  @Test
  public void findTest(){
    Page<Conference> page = conferenceService.getPage(1, 10);
    page.forEach(System.out::println);
  }
}
