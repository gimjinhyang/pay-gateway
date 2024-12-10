/*
 * Copyright ⓒ 2011 Hellomarket Inc. All Rights Reserved
 */
package pay.gateway.thirdparty.token.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 토큰 발급 결과
 *
 * @author Jinny
 */
@Getter
@Setter
@ToString
public class TokenResponse {

  /**
   * 상태값
   */
  private int status;

  /**
   * 상태 메시지
   */
  private String message;

  /**
   * 응답 데이터
   */
  private Data data;

  @Getter
  @Setter
  @ToString
  public static class Data {

    private String token;

  }
}
