package pay.gateway.thirdparty.token.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 카드 등록 파라미터
 *
 * @author Jinhyang
 */
@Getter
@Setter
@ToString
public class CardRequest {

  /**
   * 결제자 CI
   */
  private String payerCi;

  /**
   * 결제자 이름
   */
  private String payerName;

  /**
   * 카드 코드
   */
  private String code;

  /**
   * 카드 번호
   */
  private String number;

  /**
   * 카드 유효기간 년도
   */
  private String validYear;

  /**
   * 카드 유효기간 월
   */
  private String validMonth;

  /**
   * 카드 CVS
   */
  private String cvs;

}
