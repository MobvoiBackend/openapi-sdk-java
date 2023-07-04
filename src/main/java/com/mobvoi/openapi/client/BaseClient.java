package com.mobvoi.openapi.client;

import com.mobvoi.openapi.model.BaseRequest;
import com.mobvoi.openapi.signature.Md5Signature;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.DateUtil;
import com.mobvoi.openapi.util.OkHttpUtil;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.apache.commons.lang3.StringUtils;

/**
 * @author mobvoi
 * @date 2023/06/07
 **/
@Slf4j
public abstract class BaseClient {

  private ClientConfig config;

  private OkHttpClient okHttpClient;

  private WebSocket webSocket;

  public BaseClient(String appKey, String appSecret) {
    this(appKey, appSecret, Md5Signature.getInstance());
  }

  public BaseClient(String appKey, String appSecret, Signature signature) {
    this.config = newClientConfig(appKey, appSecret, signature);
    this.okHttpClient = newOkHttpClient(config);
  }

  public BaseClient(ClientConfig config) {
    this.config = config;
    this.okHttpClient = newOkHttpClient(config);
  }

  private ClientConfig newClientConfig(String appKey, String appSecret, Signature signature) {
    return ClientConfig.builder()
        .appKey(appKey)
        .appSecret(appSecret)
        .signature(signature)
        .build();
  }

  private OkHttpClient newOkHttpClient(ClientConfig config) {
    return new OkHttpClient.Builder()
        .retryOnConnectionFailure(config.isRetryOnConnectionFailure())
        .pingInterval(config.getPingInterval(), TimeUnit.SECONDS)
        .connectTimeout(config.getConnectTimeout(), TimeUnit.SECONDS)
        .readTimeout(config.getReadTimeout(), TimeUnit.SECONDS)
        .writeTimeout(config.getWriteTimeout(), TimeUnit.SECONDS)
        .build();
  }

  public WebSocket newWebSocket(Request request, WebSocketListener listener) {
    webSocket = okHttpClient.newWebSocket(request, listener);
    return webSocket;
  }

  public void closeWebsocket() {
    if (webSocket != null) {
      webSocket.close(1000, null);
      okHttpClient.connectionPool().evictAll();
    }
  }

  public ClientConfig getConfig() {
    return config;
  }

  public OkHttpClient getOkHttpClient() {
    return okHttpClient;
  }

  public WebSocket getWebSocket() {
    return webSocket;
  }

  protected String getUrl(BaseRequest request, String def) {
    return (StringUtils.isNotBlank(request.getUrl()) ? request.getUrl() : def);
  }

  protected void addSignatureInfo(BaseRequest request) {
    request.setAppkey(config.getAppKey());
    request.setTimestamp(DateUtil.timestamp());
    request.setSignature(config.getSignature()
        .digest(config.getAppKey(), config.getAppSecret(), request.getTimestamp()));
  }

  protected String execute(Request request) {
    log.debug("request={} body={}", request, request.body());
    return OkHttpUtil.execute(okHttpClient, request);
  }

  protected Response executeResponse(Request request) {
    log.debug("request={} body={}", request, request.body());
    return OkHttpUtil.executeResponse(okHttpClient, request);
  }

}
