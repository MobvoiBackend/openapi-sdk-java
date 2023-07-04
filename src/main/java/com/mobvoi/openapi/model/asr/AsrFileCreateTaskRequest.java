package com.mobvoi.openapi.model.asr;

import com.mobvoi.openapi.model.BaseRequest;
import java.util.List;
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
public class AsrFileCreateTaskRequest extends BaseRequest {

  /**
   * 音频文件的URL，需可以公网访问。如：
   */
  private String audio_url;

  /**
   * 语言。默认为"zh_cn"（中文）
   */
  private String language;

  /**
   * 标点开关。默认true，表示开启加标点，输出带标点
   */
  private Boolean enable_punctuation;

  /**
   * 语气词列表
   */
  private List<String> filler_words;

  /**
   * 当识别任务完成后，会调用该回调地址
   */
  private String callbackUrl;

}
