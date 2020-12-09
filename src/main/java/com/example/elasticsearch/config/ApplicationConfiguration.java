package com.example.elasticsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author haitao zhu
 * @date 2020/11/27 16:21
 * <p>
 * 使 Spring Data 基础结构了解定制的存储库基类
 */
@Configuration
public class ApplicationConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
