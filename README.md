# spring-data-elasticsearch-demo
https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#preface  
测试 spring-data-elasticsearch 教程各个方法  
测试过程中发现有些方法引用的包是不同的，所以拆分了不同的dev-xxx 分支进行

##### dev-base
    测试基础分支，仅包含部分配置，以及初试插入、查询数据示例
    
##### dev-001
    CrudRepository 基本的用法
    使用 Sort 排序； Pageable 分页
    
##### dev-002
    使用的ElasticsearchRepository 自带的查询扩展，实现分页，条件，模糊查询
    以及删改操作
    
##### dev-003
    使用的ElasticsearchRepository 自带的查询扩展，实现分页，条件，模糊查询
    以及删改操作
    修改测试对象
    
    使用spring-data-elasticsearch 的 @Query注解测试 elasticsearch profile查询
    
