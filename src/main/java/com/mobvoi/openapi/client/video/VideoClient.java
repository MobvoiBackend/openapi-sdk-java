package com.mobvoi.openapi.client.video;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.video.ComposeResultRequest;
import com.mobvoi.openapi.model.video.ComposeVideoRequest;
import com.mobvoi.openapi.model.video.GetManInfoRequest;
import com.mobvoi.openapi.model.video.TypefaceRequest;
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
public class VideoClient extends BaseClient {

  private static final String URL_GET_MAN_INFO = "https://open.mobvoi.com/avatar/get/man/infos";
  private static final String URL_CMP_VIDEO = "https://open.mobvoi.com/cmp/video";
  private static final String URL_CMP_RESULT = "https://open.mobvoi.com/cmp/result";
  private static final String URL_TYPEFACE = "https://open.mobvoi.com/typeface";

  public VideoClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public VideoClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public VideoClient(ClientConfig config) {
    super(config);
  }

  public String getManInfo(GetManInfoRequest request) {
    String url = getUrl(request, URL_GET_MAN_INFO);
    String json = JsonUtil.toJson(request);
    log.debug("getManInfo request={}", json);
    return execute(OkHttpUtil.buildPostJson(url, null, json));
  }

  public String composeVideo(ComposeVideoRequest request) {
    String url = getUrl(request, URL_CMP_VIDEO);
    addSignatureInfo(request);
    Map<String, Object> params = JsonUtil.toMap(request);
    params.remove("appkey");
    params.put("appKey", request.getAppkey());
    log.debug("composeVideo request={}", params);
    return execute(OkHttpUtil.buildPostJson(url, null, JsonUtil.toJson(params)));
  }

  public String getComposeResult(ComposeResultRequest request) {
    String url = getUrl(request, URL_CMP_RESULT);
    log.debug("composeResult request={}", request);
    return execute(OkHttpUtil.buildGet(url, null, JsonUtil.toMapStr(request)));
  }

  public String getTypeface(TypefaceRequest request) {
    String url = getUrl(request, URL_TYPEFACE);
    log.debug("getTypeface request={}", request);
    return execute(OkHttpUtil.buildGet(url, null, JsonUtil.toMapStr(request)));
  }
}
