package com.example.elasticsearch.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:14
 */
@Data
@Builder
@Document(indexName = "conference-index")
public class Conference {

  @Id
  @Field(type = FieldType.Keyword)
  private String id;
  @Field(type = FieldType.Text, fielddata = true)
  private String name;
  @Field(type = FieldType.Date)
  private String date;
  private GeoPoint location;
  @Field(type = FieldType.Keyword)
  private List<String> keywords;

  // do not remove it
  public Conference() {
  }

  // do not remove it - work around for lombok generated constructor for all params
  public Conference(String id, String name, String date, GeoPoint location, List<String> keywords) {

    this.id = id;
    this.name = name;
    this.date = date;
    this.location = location;
    this.keywords = keywords;
  }
}
