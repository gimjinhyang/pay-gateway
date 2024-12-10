package pay.gateway.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pay.gateway.request.PayRequest;
import pay.gateway.thirdparty.token.request.CardRequest;
import pay.gateway.thirdparty.token.request.TokenRequest;
import pay.gateway.thirdparty.token.service.TokenService;

/**
 * 결제 서비스
 *
 * @author Jinhyang
 */
@RequiredArgsConstructor
@Component
public class PaymentService {

  private final TokenService tokenService;

  /**
   * 결제 요청
   *
   * @param param {@link CardRequest}
   * @return 카드 ID
   */
  public void payment(PayRequest param) {

    // 토큰 발급 요청
    final String token = requestToken(param);

    // 결제 승인 요청


  }

  /**
   * 토큰 발급 요청
   *
   * @param param {@link PayRequest}
   * @return 토큰 문자열
   */
  private String requestToken(PayRequest param) {
    final TokenRequest token = new TokenRequest(param.getCardRefId());
    return tokenService.entry(token);
  }


}
