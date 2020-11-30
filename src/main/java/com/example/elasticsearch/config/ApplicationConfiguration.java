package com.example.elasticsearch.config;

import com.example.elasticsearch.repository.impl.MyRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author haitao zhu
 * @date 2020/11/27 16:21
 *
 * 使 Spring Data 基础结构了解定制的存储库基类
 */
@Configuration
@EnableJpaRepositories(repositoryBaseClass = MyRepositoryImpl.class)
public class ApplicationConfiguration {
}
