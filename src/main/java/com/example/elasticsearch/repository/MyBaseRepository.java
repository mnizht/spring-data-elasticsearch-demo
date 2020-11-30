package com.example.elasticsearch.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * @author haitao zhu
 * @date 2020/11/27 14:54
 *
 * 自定义存储接口，可以选择性的公开 CRUD 方法
 * 中间存储库接口用@NoRepositoryBean注释。确保将注释添加到所有存储库接口，Spring Data不应在运行时为其创建实例
 */
@NoRepositoryBean
public interface MyBaseRepository<T,ID> extends Repository<T,ID> {

  Optional<T> findById(ID id);

  <S extends T> S save(S entity);
}
