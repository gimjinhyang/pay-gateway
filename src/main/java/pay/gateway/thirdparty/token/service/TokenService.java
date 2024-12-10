package pay.gateway.thirdparty.token.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pay.gateway.properties.TokenProperties;
import pay.gateway.thirdparty.token.request.TokenRequest;
import pay.gateway.thirdparty.token.response.TokenResponse;

/**
 * 토큰 발급 서비스
 *
 * @author Jinhyang
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class TokenService {

  private final TokenProperties tokenProperties;

  /**
   * 토큰 발급
   *
   * @param param {@link TokenRequest}
   * @return 토큰 문자열
   */
  public String entry(TokenRequest param) {

    final String uri = makeUri();
    log.debug("Verify URI: {}", uri);

    // 토큰 발급 요청
    final RestClient restClient = RestClient.create();
    final ResponseEntity<TokenResponse> response = restClient.post()
                                                             .uri(uri)
                                                             .contentType(MediaType.APPLICATION_JSON)
                                                             .body(param)
                                                             .retrieve()
                                                             .toEntity(TokenResponse.class);

    // 오류 확인
    verifyError(response);

    return response.getBody().getData().getToken();
  }

  /**
   * 토큰 발급 요청 URL 생성
   *
   * @return
   */
  private String makeUri() {
    return StringUtils.join(tokenProperties.getUrl(), tokenProperties.getApiToken());
  }

  /**
   * 오류가 있는지 확인
   *
   * @param response 요청 결과
   */
  private void verifyError(ResponseEntity<TokenResponse> response) {
    if (response.getBody() == null) {
      throw new IllegalStateException("토큰 발급을 실패 했습니다.");
    }
    if (!response.getStatusCode().is2xxSuccessful() || response.getBody().getStatus() != 200) {
      throw new IllegalStateException(response.getBody().getMessage());
    }
  }

}
