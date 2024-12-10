package pay.gateway.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 결제 파라미터
 *
 * @author Jinhyang
 */
@Getter
@Setter
@ToString
public class PayRequest {

  /**
   * 등록 카드 ID
   */
  private Long cardRefId;

}
