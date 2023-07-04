package com.mobvoi.openapi.client.asr;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.asr.AsrFileCreateTaskRequest;
import com.mobvoi.openapi.model.asr.AsrFileGetTaskRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class AsrFileClient extends BaseClient {

  private static final String URL_CREATE = "https://open.mobvoi.com/api/asr/create";
  private static final String URL_GET = "https://open.mobvoi.com/api/asr/get";

  public AsrFileClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public AsrFileClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public AsrFileClient(ClientConfig config) {
    super(config);
  }

  public String createTask(AsrFileCreateTaskRequest request) {
    String url = getUrl(request, URL_CREATE);
    addSignatureInfo(request);
    Map<String, Object> params = JsonUtil.toMap(request);
    params.remove("appkey");
    params.put("appKey", request.getAppkey());
    log.debug("createTask request={}", request);
    return execute(OkHttpUtil.buildPostJson(url, null, JsonUtil.toJson(params)));
  }

  public String getTask(AsrFileGetTaskRequest request) {
    String url = getUrl(request, URL_GET);
    log.debug("getTask request={}", request);
    return execute(OkHttpUtil.buildGet(url, null, JsonUtil.toMapStr(request)));
  }
}
