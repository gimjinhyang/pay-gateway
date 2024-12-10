package pay.gateway.thirdparty.approval.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import pay.gateway.properties.ApprovalProperties;
import pay.gateway.thirdparty.approval.request.ApprovalRequest;
import pay.gateway.thirdparty.approval.response.ApprovalResponse;

/**
 * 결제 승인 서비스
 *
 * @author Jinhyang
 */
@RequiredArgsConstructor
@Component
public class ApprovalService {

  private final ApprovalProperties approvalProperties;

  /**
   * 결제 승인 요청
   *
   * @param param {@link ApprovalRequest}
   */
  public void approval(ApprovalRequest param) {

    final String uri = makeUri();
    final RestClient restClient = RestClient.create();

    // 카드 등록 요청
    final ResponseEntity<ApprovalResponse> response = restClient.post()
                                                                .uri(uri)
                                                                .contentType(MediaType.APPLICATION_JSON)
                                                                .body(param)
                                                                .retrieve()
                                                                .toEntity(ApprovalResponse.class);

    // 오류 확인
    verifyError(response);
  }

  /**
   * 결제 승인 요청 URL 생성
   *
   * @return
   */
  private String makeUri() {
    return StringUtils.join(approvalProperties.getUrl(), approvalProperties.getApiApproval());
  }

  /**
   * 오류가 있는지 확인
   *
   * @param response 요청 결과
   */
  private void verifyError(ResponseEntity<ApprovalResponse> response) {
    if (response.getBody() == null) {
      throw new IllegalStateException("결제 승인 요청에 실패 했습니다.");
    }
    if (!response.getStatusCode().is2xxSuccessful() || response.getBody().getStatus() != 200) {
      throw new IllegalStateException(response.getBody().getMessage());
    }
  }

}
