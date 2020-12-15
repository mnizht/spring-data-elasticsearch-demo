package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.OrgIdNameDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author haitao zhu
 * @date 2020/12/14 18:17
 */
public interface OrgRepository extends ElasticsearchRepository<OrgIdNameDTO, String> {

}
