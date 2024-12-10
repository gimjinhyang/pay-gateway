package pay.gateway.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import lombok.RequiredArgsConstructor;
import pay.gateway.request.CardRequest;

/**
 * 카드 등록 서비스
 *
 * @author Jinhyang
 */
@RequiredArgsConstructor
@Component
public class CardEntryService {


  /**
   * 카드 등록
   *
   * @param param {@link CardRequest}
   * @return 카드 ID
   */
  public Long entry(CardRequest param) {


    final RestClient restClient = RestClient.create();


    return 0L;
  }
}
