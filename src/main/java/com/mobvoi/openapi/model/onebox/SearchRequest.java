package com.mobvoi.openapi.model.onebox;

import com.mobvoi.openapi.model.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest extends BaseRequest {

  /**
   * 查询语句
   */
  private String query;

  /**
   * 用户地址（国家,省份,城市,区/镇,街道,街排号,纬度,经度），其中经纬度采用百度坐标系
   */
  private String address;

  /**
   * 默认传lite
   */
  private String output;

  /**
   * 是否显示debug信息
   */
  private boolean debug;

  /**
   * 指定domain，比如: public.weather、public.restaurant、public.music等
   */
  private String task;

  /**
   * 默认传43000
   */
  private String version;

  /**
   * 是否忽略多轮会话，默认为false
   */
  private boolean ignore_context;

  /**
   * 用户ID，可根据需求由开发者生成
   */
  private String user_id;

}
