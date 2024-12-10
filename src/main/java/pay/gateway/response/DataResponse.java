package pay.gateway.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;

import lombok.Getter;
import lombok.ToString;

/**
 * Data 공동 반환 클래스
 *
 * @author Jinhyang
 */
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "message", "data"})
public class DataResponse extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -342444435031151223L;

    /**
     * 데이터
     */
    private Object data;

    // ////////////////////////////////////////////////////////////////////////////////////
    //
    // Constructors
    //
    // ////////////////////////////////////////////////////////////////////////////////////
    public DataResponse(int status, String message, Object data) {
        this.setStatus(status);
        this.setMessage(message);
        this.data = data;
    }

    public DataResponse(Object data) {
        this.data = data;
    }

    public DataResponse(String message, Object data) {
        this.setMessage(message);
        this.data = data;
    }

}
