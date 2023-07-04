package com.mobvoi.openapi.client.nlp;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.nlp.NlpRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class NlpClient extends BaseClient {

  private static final String URL = "https://open.mobvoi.com/api/nlp/v1";

  public NlpClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public NlpClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public NlpClient(ClientConfig config) {
    super(config);
  }

  public String nlp(NlpRequest request) {
    String url = getUrl(request, URL);
    addSignatureInfo(request);
    log.debug("nlp request={}", request);
    return execute(OkHttpUtil.buildGet(url, null, JsonUtil.toMapStr(request)));
  }

}
