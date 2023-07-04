package com.mobvoi.openapi.model.nlp;

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
public class NlpRequest extends BaseRequest {

  /**
   * 查询语句
   */
  private String query;

  /**
   * 强制指定意图
   */
  private String context;

}
