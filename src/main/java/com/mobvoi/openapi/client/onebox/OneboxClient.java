package com.mobvoi.openapi.client.onebox;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.onebox.SearchRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class OneboxClient extends BaseClient {

  private static final String URL = "https://open.mobvoi.com/api/search/v1";

  public OneboxClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public OneboxClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public OneboxClient(ClientConfig config) {
    super(config);
  }

  public String search(SearchRequest request) {
    String url = getUrl(request, URL);
    addSignatureInfo(request);
    log.debug("search request={}", request);
    return execute(OkHttpUtil.buildGet(url, null, JsonUtil.toMapStr(request)));
  }

}
