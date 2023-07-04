package com.mobvoi.openapi.model.video;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
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
public class ComposeVideoRequest extends BaseRequest {

  /**
   * 音频地址，需公网可访问，当不传时，ttsParam必传
   */
  private String audioUrl;

  /**
   * 模特ID
   */
  private Long wetaSpeakerId;

  /**
   * 自定义背景，需公网可访问
   */
  private String backUrl;

  /**
   * 合成作品名称
   */
  private String videoName;

  /**
   * 视频码率 可选值：1M、1.5M、3M、3.5M、5M、7M、8M、10M、12M、16M
   */
  private String bitRate;

  /**
   * 横向分辨率（默认’1080’）
   */
  private Integer width;

  /**
   * 纵向分辨率（默认’1920’）
   */
  private Integer height;

  /**
   * fps 可选值："15"、 "20"、 "25"、 "30"
   */
  private Integer fps;

  /**
   * 合成结果回调地址，不填则不回调，失败重试3次，建议接口幂等处理
   */
  private String callbackUrl;

  /**
   * 目前默认为mp4
   */
  private String videoFormat;

  /**
   * 控制模特大小及位置(注意：目前该功能只支持输出mp4格式视频)
   */
  private Style style;

  /**
   * 素材信息
   */
  private JSONArray materials;

  /**
   * 合成类型(video:默认方式,视频合成结果;manWebm:数字人的webm格式;manWebmAudio:带音频得webm格式视频;videoAlpha:视频的合成结果，加alpha通道，加数字人)
   */
  private String resultType;

  /**
   * 语音合成相关参数
   */
  private JSONObject ttsParam;
}
