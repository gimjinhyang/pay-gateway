package pay.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pay.gateway.request.PayRequest;
import pay.gateway.response.ErrorResponse;
import pay.gateway.service.PaymentService;

/**
 * 결제 컨트롤러
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/pay")
public class PayController {

  private final PaymentService paymentService;

  /**
   * 카드 등록 요청
   *
   * @param param {@link PayRequest}
   * @return
   */
  @PostMapping
  public ResponseEntity<?> post(@RequestBody PayRequest param) {
    try {

      paymentService.payment(param);
      return ResponseEntity.ok(new ErrorResponse(HttpStatus.OK, "ok"));

    } catch (IllegalStateException e) {
      log.warn("caught a " + e.getClass() + " with message: " + e.getMessage(), e);
      return ResponseEntity.ok(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    } catch (Exception e) {
      log.warn("caught a " + e.getClass() + " with message: " + e.getMessage(), e);
      return ResponseEntity.ok(new ErrorResponse(HttpStatus.BAD_REQUEST, "결제를 실패했습니다"));
    }
  }

}
