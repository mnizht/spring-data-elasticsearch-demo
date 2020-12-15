package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.OrgIdNameDTO;
import com.example.elasticsearch.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author haitao zhu
 * @date 2020/12/14 18:18
 */
@Service
public class OrgService {
  @Autowired
  private OrgRepository orgRepository;

  public OrgIdNameDTO saveOne(OrgIdNameDTO dto){
    return orgRepository.save(dto);
  }

  public Iterable<OrgIdNameDTO> saveAll(Collection<OrgIdNameDTO> dtos){
    return orgRepository.saveAll(dtos);
  }
}
