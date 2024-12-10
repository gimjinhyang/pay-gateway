/*
 * Copyright ⓒ 2011 Hellomarket Inc. All Rights Reserved
 */
package pay.gateway.thirdparty.approval.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 결제 승인 결과
 *
 * @author Jinny
 */
@Getter
@Setter
@ToString
public class ApprovalResponse {

  /**
   * 상태값
   */
  private int status;

  /**
   * 상태 메시지
   */
  private String message;

}
