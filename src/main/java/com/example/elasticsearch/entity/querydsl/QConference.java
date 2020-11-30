package com.example.elasticsearch.entity.querydsl;

import com.example.elasticsearch.entity.Conference;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;

/**
 * @author haitao zhu
 * @date 2020/11/27 18:07
 */
public class QConference extends EntityPathBase<Conference> {

  private static final long serialVersionUID = 1597461318239306286L;

  public static final QConference conference = new QConference("conference");

  public final StringPath name = createString("name");

  public final DateTimePath<java.time.ZonedDateTime> date = createDateTime("date", java.time.ZonedDateTime.class);


  public QConference(String variable) {
    super(Conference.class, variable);
  }
}
