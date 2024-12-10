package pay.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 토큰 Property
 *
 * @author Jinhyang
 */
@Getter
@Setter
@ToString
@ConfigurationProperties("token")
public class TokenProperties {

  /**
   * 주소
   */
  private String url;

  /**
   * 카드 등록 API
   */
  private String apiCard;

  /**
   * 토큰 발급 API
   */
  private String apiToken;

}
