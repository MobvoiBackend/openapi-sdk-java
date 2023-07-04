package com.mobvoi.openapi.model.asr;

import com.mobvoi.openapi.model.BaseRequest;
import java.io.File;
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
public class AsrRequest extends BaseRequest {

  /**
   * 要解析的音频文件,最大为512k wav/mp3/pcm
   */
  private File audioFile;

  /**
   * 该请求头为音频的请求头类型见附表1.5
   */
  private String type;

  /**
   * 用户的唯一id,有则填写
   */
  private String user_id;

  /**
   * 设备的唯一id,有则填写
   */
  private String device_id;

}
