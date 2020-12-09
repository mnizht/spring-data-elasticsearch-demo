package com.example.elasticsearch;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Random;

/**
 * @author haitao zhu
 * @date 2020/12/8 19:11
 */
public class GeoPointFactory {
  private GeoPointFactory() {
  }

  private static Random random;

  public static GeoPoint getGeoPoint() {
    return new GeoPoint(0.0, 0.0);
  }
}
