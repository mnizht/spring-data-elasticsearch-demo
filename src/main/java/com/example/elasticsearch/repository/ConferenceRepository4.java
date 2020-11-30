package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Conference;
import org.springframework.data.repository.CrudRepository;

/**
 * @author haitao zhu
 * @date 2020/11/27 15:28
 *
 * 接口继承了 CustomizedSave 接口，再有使用这个接口的save方法时，会调用自定义的save方法 CustomizedSaveImpl.save()
 */
public interface ConferenceRepository4 extends CrudRepository<Conference,String>,CustomizedSave<Conference> {
}
