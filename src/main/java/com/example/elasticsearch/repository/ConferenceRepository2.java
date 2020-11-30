package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;

/**
 * @author haitao zhu
 * @date 2020/11/27 14:58
 */
public interface ConferenceRepository2 extends MyBaseRepository<Conference, String> {

  Conference findByName(String name);
}
