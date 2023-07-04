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
public class AsrSentenceStartRequest extends BaseRequest {

  /**
   * 语音格式 目前主要支持pcm和wav格式，需要指定具体的采样率等信息，比如：audio/x-wav;codec=pcm;bit=16;rate=16000
   */
  private String contentType;

  /**
   * 是否需要解码中间结果，通常只在实时语音识别场景中使用 enable|disable
   */
  private String partial_result;

  /**
   * 是否开启服务端静音监测，一般建议开启 enable|disable
   */
  private String silence_detection;
}
