package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:19
 */
public interface ConferenceRepository extends ElasticsearchRepository<Conference, String> {

}
