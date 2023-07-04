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
public class GetManInfoRequest extends BaseRequest {

  /**
   * 页码，最小为1
   */
  @Builder.Default
  private Integer current = 1;

  /**
   * 页数，最小为1
   */
  @Builder.Default
  private Integer size = 10;

  /**
   * 数字人类型（系统:sys;定制:self）
   */
  private String customType;

  /**
   * 语气词列表
   */
  private String speakerName;

  /**
   * 定制数字人对的账户的任意应用key（在开放平台创建），当customType为self时，appKey必填
   */
  private String appKey;

}
