package com.example.elasticsearch;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

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

  /**
   * 可以正常执行
   */
  @Test
  public void getPageTest() {
    int page = 0;
    int size = 10;
    Sort sort = Sort.by("date");
    Page<Conference> pageData = conferenceService.getPage(page, size, sort);
    System.out.println("total: " + pageData.getTotalElements());
    pageData.forEach(System.out::println);
  }

  /**
   * 默认设置执行此方法会报错
   * Alternatively, set fielddata=true on [name] in order to load field data by uninverting the inverted index. Note that this can use significant memory.
   * name 是 text 类型字段，在使用 ElasticSearch 时，如果索引中的字段是 text 类型，针对该字段聚合、排序和查询的时候经常会出现此错误。
   * 因为 Fielddata 默认在 text 类型字段是不启用的，开启的话可能会消耗大量内存
   */
  @Test
  public void getPageTest2() {
    int page = 0;
    int size = 10;
    Sort sort = Sort.by("name");
    Page<Conference> pageData = conferenceService.getPage(page, size, sort);
    System.out.println("total: " + pageData.getTotalElements());
    pageData.forEach(System.out::println);
  }
}
