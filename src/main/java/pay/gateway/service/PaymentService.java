package pay.gateway.service;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pay.gateway.request.PayRequest;
import pay.gateway.thirdparty.approval.request.ApprovalRequest;
import pay.gateway.thirdparty.approval.service.ApprovalService;
import pay.gateway.thirdparty.token.request.CardRequest;
import pay.gateway.thirdparty.token.request.TokenRequest;
import pay.gateway.thirdparty.token.service.TokenService;

/**
 * 결제 서비스
 *
 * @author Jinhyang
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentService {

  private final TokenService tokenService;
  private final ApprovalService approvalService;

  /**
   * 결제 요청
   *
   * @param param {@link CardRequest}
   * @return 카드 ID
   */
  public void payment(PayRequest param) {

    // 토큰 발급 요청
    log.info("token request: {}", param.getCardRefId());
    final String token = requestToken(param);

    // 결제 승인 요청
    log.info("approval request: {}", token);
    requestApproval(token);
  }

  /**
   * 결제 승인 요청
   *
   * @param token 토큰 문자열
   */
  private void requestApproval(String token) {
    final ApprovalRequest approval = new ApprovalRequest(token);
    approvalService.approval(approval);
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
