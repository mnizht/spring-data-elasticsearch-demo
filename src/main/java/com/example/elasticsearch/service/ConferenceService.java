package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.repository.ConferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:21
 */
@Service
public class ConferenceService {

  private Logger log = LoggerFactory.getLogger(ConferenceService.class);

  @Autowired
  private ElasticsearchOperations elasticsearchOperations;
  @Autowired
  private ConferenceRepository repository;

  // region CrudRepository

  public void crud() {
    System.out.println("========================= count =================================");
    System.out.println("===== count = " + repository.count());

    System.out.println("========================= sort =================================");
//    repository.findAll(Sort.unsorted()).forEach(System.out::println);
    repository.findAll(Sort.by("name").descending()).forEach(System.out::println);


    System.out.println("========================= page =================================");
    Pageable pageable = PageRequest.of(0, 2);
//    repository.findAll(Pageable.unpaged());
    Page<Conference> page = repository.findAll(pageable);
    page.forEach(System.out::println);

    System.out.println("========================= delete =================================");
//    repository.deleteAll(page.getContent());

  }
  // endregion

  public Iterable<Conference> getAll() {
    return repository.findAll();
  }

  public void insertDataSample() {
    repository.deleteAll();
    elasticsearchOperations.indexOps(Conference.class).refresh();
    log.info("deleted all conference index");

    // Save data sample
    repository.save(Conference.builder().date("2014-11-06").name("Spring eXchange 2014 - London")
      .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    repository.save(Conference.builder().date("2014-12-07").name("Scala eXchange 2014 - London")
      .keywords(Arrays.asList("scala", "play", "java")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    repository.save(Conference.builder().date("2014-11-20").name("Elasticsearch 2014 - Berlin")
      .keywords(Arrays.asList("java", "elasticsearch", "kibana")).location(new GeoPoint(52.5234051D, 13.4113999))
      .build());
    repository.save(Conference.builder().date("2014-11-12").name("AWS London 2014")
      .keywords(Arrays.asList("cloud", "aws")).location(new GeoPoint(51.500152D, -0.126236D)).build());
    repository.save(Conference.builder().date("2014-10-04").name("JDD14 - Cracow")
      .keywords(Arrays.asList("java", "spring")).location(new GeoPoint(50.0646501D, 19.9449799)).build());
    log.info("save some conference data");
  }

  /**
   * 修改了实体的字段属性或映射后，需要重新生成index。此处只是简单的做了删除，在插入数据时会重新生成index
   */
  public void deleteIndex() {
    elasticsearchOperations.indexOps(Conference.class).delete();
    log.info("deleted conference-index");
  }
}
