package com.mobvoi.openapi.model;

import com.mobvoi.openapi.util.JsonUtil;
import java.io.Serializable;
import lombok.Data;

/**
 * @author mobvoi
 * @date 2023/06/07
 **/
@Data
public abstract class BaseRequest implements Serializable {

  private transient String url;

  /**
   * 开放平台注册的appKey
   */
  private String appkey;

  /**
   * 授权码
   */
  private String signature;

  /**
   * 时间戳。传入当前时间戳，单位为秒
   */
  private String timestamp;

  public String toString() {
    return JsonUtil.toJson(this);
  }
}
