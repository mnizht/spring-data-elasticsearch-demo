package com.example.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/8 15:14
 */
@Data
@Accessors(chain = true)
public class TagGroup {

  private String id;
  private String name;
  private List<Tag> tags;

}

@Data
@Accessors(chain = true)
class Tag {
  private String id;
  private String name;
}
