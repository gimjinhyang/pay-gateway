package pay.gateway.controller;

import com.google.common.collect.ImmutableMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pay.gateway.request.CardRequest;
import pay.gateway.response.DataResponse;
import pay.gateway.response.ErrorResponse;
import pay.gateway.service.CardEntryService;

/**
 * 카드 등록 컨트롤러
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/card")
public class CardController {

  private final CardEntryService cardEntryService;

  /**
   * 카드 등록 요청
   *
   * @param param {@link CardRequest}
   * @return
   */
  @PostMapping
  public ResponseEntity<?> post(@RequestBody CardRequest param) {
    try {

      final Long cardRefId = cardEntryService.entry(param);
      return ResponseEntity.ok(new DataResponse(ImmutableMap.of("cardRefId", cardRefId)));

    } catch (IllegalArgumentException e) {
      log.warn("caught a " + e.getClass() + " with message: " + e.getMessage(), e);
      return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    } catch (Exception e) {
      log.warn("caught a " + e.getClass() + " with message: " + e.getMessage(), e);
      return ResponseEntity.badRequest().body(new ErrorResponse(HttpStatus.BAD_REQUEST, "카드 등록을 실패했습니다"));
    }
  }

}
