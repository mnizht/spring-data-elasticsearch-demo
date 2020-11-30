package com.example.elasticsearch.repository.impl;

import com.example.elasticsearch.repository.CustomizedSave;

/**
 * @author haitao zhu
 * @date 2020/11/27 15:27
 */
public class CustomizedSaveImpl<T> implements CustomizedSave<T> {
  @Override
  public <S extends T> S save(S entity) {
    // 自定义的实现
    return null;
  }
}
