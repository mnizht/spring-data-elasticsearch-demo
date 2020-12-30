package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private ElasticsearchOperations elasticsearchOperations;
  @Autowired
  private ConferenceRepository repository;


  public Iterable<Conference> findAll() {
    return repository.findAll();
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
