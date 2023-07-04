package com.mobvoi.openapi.client;

import com.mobvoi.openapi.signature.Signature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mobvoi
 * @date 2023/06/07
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientConfig {

  private String appKey;
  private String appSecret;
  private Signature signature;

  private boolean retryOnConnectionFailure;
  private int pingInterval;
  @Builder.Default
  private int connectTimeout = 10;
  @Builder.Default
  private int readTimeout = 10;
  @Builder.Default
  private int writeTimeout = 10;

  public static void main(String[] args) {
    System.out.println(ClientConfig.builder().build());
  }
}
