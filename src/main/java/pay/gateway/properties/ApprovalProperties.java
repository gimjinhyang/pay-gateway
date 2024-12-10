package pay.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 결제 승인 Property
 *
 * @author Jinhyang
 */
@Getter
@Setter
@ToString
@ConfigurationProperties("approval")
public class ApprovalProperties {

  /**
   * 주소
   */
  private String url;

  /**
   * 결제 승인 API
   */
  private String apiApproval;


}
