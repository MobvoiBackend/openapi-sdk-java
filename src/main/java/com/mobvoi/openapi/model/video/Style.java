package com.mobvoi.openapi.model.video;

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
public class Style extends BaseRequest {

  /**
   * 控制模特水平方向位置
   */
  private Integer x;

  /**
   * 控制模特垂直方向位置
   */
  private Integer y;

  /**
   * 控制模特宽度
   */
  private Integer width;

  /**
   * 控制模特高度
   */
  private Integer height;

}
