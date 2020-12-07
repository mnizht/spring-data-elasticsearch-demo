package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Conference;
import com.example.elasticsearch.repository.ConferencePagingAndSortingRepository;
import com.example.elasticsearch.repository.ConferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haitao zhu
 * @date 2020/11/25 18:21
 */
@Service
public class ConferenceService {

  @Autowired
  private ElasticsearchOperations elasticsearchOperations;
  @Autowired
  private ConferenceRepository repository;
  @Autowired
  private ConferencePagingAndSortingRepository pagingAndSortingRepository;


  private final Logger log = LoggerFactory.getLogger(ConferenceService.class);

  // region C

  /**
   * @param dataList 数据列表
   * @return 插入或修改的对象列表，插入的记录会补上id
   */
  public Iterable<Conference> insertDataSample(List<Conference> dataList) {
    return repository.saveAll(dataList);
    // Save data sample

  }

  /**
   * @param conference 对象参数。有id时会按新值修改，没id时会添加一条新记录。 允许字段被修改为null
   * @return 修改或保存后的对象
   */
  public Conference saveOne(Conference conference) {
    return repository.save(conference);
  }

  // endregion

  // region R

  public Page<Conference> getPage(int page, int size) {
    Page<Conference> conferences = pagingAndSortingRepository.findAll(PageRequest.of(page, size));
    if (conferences.isFirst()) {
      log.info("slice 这个方法也不知道能干什么");
    }
    return conferences;
  }

  /**
   * @param name 全匹配名称
   * @return 查询结果列表
   */
  public List<Conference> getListByName(String name) {
    return repository.findByName(name);
  }

  // endregion

  // region U

  /**
   * @param conference 对象参数。有id时会按新值修改，没id时会添加一条新记录。 允许字段被修改为null
   * @return 修改或保存后的对象
   */
  public Conference updateOne(Conference conference) {
    return repository.save(conference);
  }

  // endregion

  // region D

  /**
   * @param name 名字
   * @return 按名字删除的记录数
   */
  public long deleteByName(String name) {
    return repository.deleteByName(name);
  }

  /**
   * @param name 名字
   * @return 按名字移除的记录对象
   */
  public List<Conference> removeByName(String name) {
    return repository.removeByName(name);
  }

  /**
   * 清空当前的仓库
   */
  public void deleteAll() {
    repository.deleteAll();
    // 删除后手动刷新一次索引。
    // 默认情况下，es每秒刷新一次，也可以修改刷新频率。 因为有这个刷新间隔，所以es是近实时的
    elasticsearchOperations.indexOps(Conference.class).refresh();
  }

  // endregion


}
