package com.mobvoi.openapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Getter
@AllArgsConstructor
public enum VideoComposeStatus {
  ING("ing", "处理中"),
  SUCCESS("suc", "成功"),
  FAIL("fail", "失败"),
  ;

  private String name;
  private String desc;
}
