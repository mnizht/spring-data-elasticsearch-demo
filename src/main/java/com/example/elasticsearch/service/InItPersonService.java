package com.example.elasticsearch.service;

import com.example.elasticsearch.dto.IdNameDto;
import com.example.elasticsearch.dto.PersonCountDTO;
import com.example.elasticsearch.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author haitao zhu
 * @date 2020/12/8 17:25
 */
@Service
public class InItPersonService {

  @Autowired
  private RestTemplate restTemplate;


  private static final String BASE_URL = "http://192.168.2.118:18400/zht/v1/api/pub";

  public List<PersonCountDTO> getFamilyCount() {
    PersonCountDTO[] body = this.restTemplate.getForEntity(BASE_URL + "/family-count", PersonCountDTO[].class).getBody();
    if (Objects.isNull(body)) {
      return Collections.emptyList();
    }
    return Arrays.asList(body);
  }


  public List<Person> getPerson(String orgId, int page, int size) {
    Person[] body = this.restTemplate.getForEntity(BASE_URL + "/family?orgId=" + orgId + "&page=" + page + "&size=" + size, Person[].class).getBody();
    if (Objects.isNull(body)) {
      return Collections.emptyList();
    }
    return Arrays.asList(body);
  }

  public List<IdNameDto> getTagGroup(String orgId) {
    IdNameDto[] body = this.restTemplate.getForEntity(BASE_URL + "/tag-group?orgId=" + orgId, IdNameDto[].class).getBody();
    if (Objects.isNull(body)) {
      return Collections.emptyList();
    }
    return Arrays.asList(body);
  }

  public List<IdNameDto> getTag(String orgId) {
    IdNameDto[] body = this.restTemplate.getForEntity(BASE_URL + "/tag?orgId=" + orgId, IdNameDto[].class).getBody();
    if (Objects.isNull(body)) {
      return Collections.emptyList();
    }
    return Arrays.asList(body);
  }
}
