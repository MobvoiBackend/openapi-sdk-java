package com.mobvoi.openapi.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Getter
@AllArgsConstructor
public enum AsrSentenceResultType {
  READY("server_ready"),
  ERROR("server_error"),
  PARTIAL("partial_result"),
  END("speech_end"),
  SILENCE("silence"),
  ;

  private String name;
}
