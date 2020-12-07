package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
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
public class Person {
  @Id
  private Long id;
  private String title;
  private String name;
  private Integer age;
  private Long wages;
  private String country;
  private Boolean owned;
  private Byte gender;
  @Field(type = FieldType.Date)
  private String date;
  private GeoPoint location;
  private List<String> keywords;


}
