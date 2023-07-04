package com.mobvoi.openapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Getter
@AllArgsConstructor
public enum AsrFileTaskStatus {
  SUBMIT(1, "提交"),
  SUCCESS(2, "成功"),
  FAIL(3, "失败"),
  ;

  private Integer code;
  private String desc;
}
