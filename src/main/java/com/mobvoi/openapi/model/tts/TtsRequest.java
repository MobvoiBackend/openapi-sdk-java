package com.mobvoi.openapi.model.tts;

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
public class TtsRequest extends BaseRequest {

  /**
   * 要合成的文本内容，限制为1000字符。支持ssml标记语言，使用说明见附录3。
   */
  private String text;

  /**
   * 合成音频指定发音人 默认值：cissy_meet 其他发音人传值及计费价格请参考声音商店。
   */
  private String speaker;

  /**
   * 合成音频的格式 默认值：mp3 可选值：pcm/mp3/speex-wb-10/wav 只支持这四种格式中的一种
   */
  private String audio_type;

  /**
   * 发音人合成的语速，支持小数点后一位 默认值：1.0 可选值：0.5-2.0
   */
  private Float speed;

  /**
   * 默认值：无 可选值：robot 是否转化为机器声
   */
  private String convert;

  /**
   * 音频采样率 默认值：无，由speaker指定默认值 可选值：8000/16000/24000
   */
  private Long rate;

  /**
   * 合成音量 默认值：1.0 可选值：0.1-1.0
   */
  private Float volume;

  /**
   * 语调参数，参数小于0则语调变低，反之则高 默认值：0 可选值：-10<pitch<10 (streaming接口不支持)
   */
  private Float pitch;

  /**
   * 符号停顿时长映射方法（逗号分割)见下方停顿符号映射表 需要指定appkey开通权限 (streaming接口不支持)
   */
  private String symbol_sil;

  /**
   * 默认值：false 可选值：false/true 是否限制字符数，如果设置true，传输的文本可以超过1000字符限制 需要指定appkey开通权限
   */
  private boolean ignore_limit;

  /**
   * 可以控制是否生成对应的srt字幕文件。当ignore_limit为true时，audio_type为wav可以返回字幕，其他类型不行。默认不生成字幕文件。生成字幕文件需要额外付费，价格详情参考报价页。srt文件地址通过response
   * header返回，参考下面response header样例。 默认值：false 可选值：false/true
   */
  private boolean gen_srt;

  /**
   * 粗粒度合成参数，默认为false。可以指定为true，打开后语气停顿会更加接近真人效果。 默认值：false 可选值：false/true
   */
  private boolean merge_symbol;

}
