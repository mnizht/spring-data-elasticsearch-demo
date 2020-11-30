package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.repository.CrudRepository;

/**
 * @author haitao zhu
 * @date 2020/11/27 15:19
 *
 * 扩展存储库接口
 */
public interface ConferenceRepository3 extends CrudRepository<Conference, String>, CustomizedConferenceRepository {
}
