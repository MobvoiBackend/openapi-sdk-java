package com.mobvoi.openapi.client.tts;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.tts.TtsRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class TtsClient extends BaseClient {

  private static final String URL = "https://open.mobvoi.com/api/tts/v1";

  public TtsClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public TtsClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public TtsClient(ClientConfig config) {
    super(config);
  }

  public Response tts(TtsRequest request) {
    String url = getUrl(request, URL);
    addSignatureInfo(request);
    log.debug("tts request={}", request);
    return executeResponse(OkHttpUtil.buildPostJson(url, null, JsonUtil.toJson(request)));
  }

  public Response srt(String srtAddress) {
    return executeResponse(OkHttpUtil.buildGet(srtAddress, null, null));
  }
}
