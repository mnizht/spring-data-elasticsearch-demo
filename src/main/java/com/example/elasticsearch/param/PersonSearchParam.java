package com.example.elasticsearch.param;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author haitao zhu
 * @date 2020/12/30 10:51
 */
@Data
@Accessors(chain = true)
public class PersonSearchParam {
  /**
   * 家长姓名。仅模糊匹配家长姓名
   */
  private String name;
  /**
   * 联系方式。仅模糊匹配联系方式
   */
  private String phone;

  /**
   * 搜索框输入搜索条件，允许
   */
  private String searchBox;
}
