package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.entity.querydsl.QConference;
import com.example.elasticsearch.repository.ConferencePagingAndSortingRepository;
import com.example.elasticsearch.repository.ConferenceRepository;
import com.example.elasticsearch.repository.ConferenceRepositoryQuerydslPredicate;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.ZonedDateTime;
import java.util.Arrays;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:21
 */
@Service
public class ConferenceService {

  @Autowired
  private ElasticsearchOperations elasticsearchOperations;
  @Autowired
  private ConferenceRepository repository;
  @Autowired
  private ConferencePagingAndSortingRepository pagingAndSortingRepository;
  @Autowired
  private ConferenceRepositoryQuerydslPredicate querydslPredicate;
  @PersistenceContext
  private EntityManager em;

  private final Logger log = LoggerFactory.getLogger(ConferenceService.class);

  public void querydslPredicateTest() {
    QConference conference = QConference.conference;
    Predicate predicate = conference.name.equalsIgnoreCase("name").and(conference.date.eq(ZonedDateTime.now()));
    querydslPredicate.findAll(predicate);
  }

  public Page<Conference> getPage(int page, int size) {
    Page<Conference> conferences = pagingAndSortingRepository.findAll(PageRequest.of(page, size));
    if (conferences.isFirst()) {
      log.info("slice 这个方法也不知道能干什么");
    }
    return conferences;
  }

  public void insertDataSample() {
    repository.deleteAll();
    elasticsearchOperations.indexOps(Conference.class).refresh();


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
  }
}
