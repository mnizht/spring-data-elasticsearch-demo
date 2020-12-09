package com.example.elasticsearch.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author haitao zhu
 * @date 2020/12/8 15:55
 */
@Data
@Accessors(chain = true)
public class PersonCountDTO {
  private String orgId;
  private Long num;
}
