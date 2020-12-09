package com.example.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
  private LocalDate birthday;
  private LocalDateTime followTime;
  private GeoPoint location;
  private List<String> keywords;

  private List<TagGroup> tagGroups;


}
