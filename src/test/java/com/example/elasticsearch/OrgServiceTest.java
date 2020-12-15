package com.example.elasticsearch;

import com.example.elasticsearch.entity.OrgIdNameDTO;
import com.example.elasticsearch.service.InItDataService;
import com.example.elasticsearch.service.OrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/12/14 18:21
 */
public class OrgServiceTest extends RootTest {

  @Autowired
  private InItDataService inItDataService;
  @Autowired
  private OrgService orgService;


  @Test
  public void initOrg() {
    List<OrgIdNameDTO> orgs = inItDataService.getOrg();
    Iterable<OrgIdNameDTO> result = orgService.saveAll(orgs);
    System.out.println("====== count = " + result.spliterator().estimateSize());

  }
}
