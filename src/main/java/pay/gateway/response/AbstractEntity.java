package pay.gateway.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Abstract domain that defines common functionality.
 */
@Getter
@Setter
@ToString
@XmlRootElement
public abstract class AbstractEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6347251273551120299L;

    /**
     * 결과 코드
     */
    @JsonProperty
    private int status = HttpStatus.OK.value();

    /**
     * 결과 메시지
     */
    @JsonProperty
    private String message = "success";

}
