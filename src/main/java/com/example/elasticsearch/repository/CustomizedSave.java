package com.example.elasticsearch.repository;

/**
 * @author haitao zhu
 * @date 2020/11/27 15:24
 *
 * 定义一些与 存储库同名的方法，覆盖它的实现
 */
public interface CustomizedSave<T> {

  <S extends T> S save(S entity);
}
