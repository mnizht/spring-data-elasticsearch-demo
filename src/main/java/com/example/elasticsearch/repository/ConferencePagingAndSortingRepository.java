package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author haitao zhu
 * @date 2020/11/26 11:17
 */
public interface ConferencePagingAndSortingRepository extends PagingAndSortingRepository<Conference, String> {
}
