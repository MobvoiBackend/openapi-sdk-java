package com.mobvoi.openapi.client.asr;

import com.mobvoi.openapi.client.BaseClient;
import com.mobvoi.openapi.client.ClientConfig;
import com.mobvoi.openapi.model.asr.AsrSentenceStartRequest;
import com.mobvoi.openapi.signature.Signature;
import com.mobvoi.openapi.util.JsonUtil;
import com.mobvoi.openapi.util.ValidateUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * @author mobvoi
 * @date 2023/06/08
 **/
@Slf4j
public class AsrSentenceClient extends BaseClient {

  private static final String URL = "wss://open.mobvoi.com/ws/asr";

  /**
   * 当客户端需要主动结束本轮交互时，发送end消息，服务端将停止识别，发送剩余结果并返回speech_end结果。
   */
  private static final String SEND_END = "{\"signal\": \"end\"}";

  /**
   * 当客户端需要取消本轮交互时，发送cancel消息，服务端将停止识别，并且不会返回识别结果。
   */
  private static final String SEND_CANCEL = "{\"signal\": \"cancel\"}";

  public AsrSentenceClient(String appKey, String appSecret) {
    super(appKey, appSecret);
  }

  public AsrSentenceClient(String appKey, String appSecret, Signature signature) {
    super(appKey, appSecret, signature);
  }

  public AsrSentenceClient(ClientConfig config) {
    super(config);
  }

  public WebSocket connect(AsrSentenceStartRequest request, WebSocketListener listener) {
    String url = getUrl(request, URL);
    addSignatureInfo(request);
    Map<String, Object> startSignal = JsonUtil.toMap(request);
    startSignal.put("signal", "start");
    startSignal.remove("appkey");
    startSignal.put("appKey", request.getAppkey());
    log.debug("asr sentence connect={}", request);
    Request wsRequest = new Builder().url(url).build();
    WebSocket webSocket = newWebSocket(wsRequest, listener);
    webSocket.send(JsonUtil.toJson(startSignal));
    return webSocket;
  }

  public void send(File file) {
    checkConnect();
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
      byte[] buffer = new byte[16000];
      int bytesRead;
      while ((bytesRead = bis.read(buffer)) != -1) {
        getWebSocket().send(ByteString.of(buffer, 0, bytesRead));
      }
    } catch (IOException e) {
      log.error("asr sentence send exception file={}", file, e);
    }
  }

  public void sendEndSignal() {
    checkConnect();
    getWebSocket().send(SEND_END);
  }

  public void sendCancelSignal() {
    checkConnect();
    getWebSocket().send(SEND_CANCEL);
  }

  private void checkConnect() {
    ValidateUtil.isTrue(getWebSocket() != null, "connect websocket first");
  }

}
