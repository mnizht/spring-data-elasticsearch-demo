package com.example.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/14 16:49
 */
@Data
@Accessors(chain = true)
@Document(indexName = "org")
public class OrgIdNameDTO {
  private String id;
  private String name;
  List<OrgIdNameDTO> orgs;
}
