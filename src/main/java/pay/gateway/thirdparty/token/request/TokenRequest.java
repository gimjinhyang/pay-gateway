package pay.gateway.thirdparty.token.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 토큰 발급 파라미터
 *
 * @author Jinhyang
 */
@Getter
@Setter
@ToString
public class TokenRequest {

  /**
   * 등록 카드 ID
   */
  private Long cardRefId;

  public TokenRequest(Long cardRefId) {
    this.cardRefId = cardRefId;
  }

}
