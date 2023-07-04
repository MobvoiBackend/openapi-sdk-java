package com.mobvoi.openapi.model.asr;

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
public class AsrFileGetTaskRequest extends BaseRequest {

  /**
   * 创建语音识别任务返回的task_id
   */
  private Long taskId;

}
