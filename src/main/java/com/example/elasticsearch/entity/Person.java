package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/7 17:25
 */
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName = "person")
public class Person {
  @Id
  private String id;
  private String name;
  private String phone;
  private Integer age;
  private Long wages;
  private String province;
  private String city;
  private Boolean owned;
  private Byte gender;
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd")
  private String birthday;
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
  private String followTime;
  private GeoPoint location;
  private List<String> keywords;

  private List<TagGroup> tagGroups;


}
