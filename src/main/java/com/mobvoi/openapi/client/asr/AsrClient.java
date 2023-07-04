package com.mobvoi.openapi.client.asr;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.asr.AsrRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class AsrClient extends BaseClient {

  private static final String URL = "https://open.mobvoi.com/api/asr/v1";

  public AsrClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public AsrClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public AsrClient(ClientConfig config) {
    super(config);
  }

  public String asr(AsrRequest request) {
    String url = getUrl(request, URL);
    addSignatureInfo(request);
    log.debug("asr request={}", request);
    Map<String, File> fileMap = new HashMap<>();
    fileMap.put("file", request.getAudioFile());
    request.setAudioFile(null);
    return execute(OkHttpUtil.buildFormData(url, JsonUtil.toMapStr(request), fileMap, "POST"));
  }

}
