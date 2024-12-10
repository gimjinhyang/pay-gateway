package pay.gateway.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

/**
 * List형 공통 반환 모델
 *
 * @author Jinhyang
 */
@Getter
@ToString
@JsonPropertyOrder({"status", "message", "list"})
public class ListResponse extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 2267052962744007580L;

    /**
     * 결과 목록
     */
    private List<?> list;

    // ////////////////////////////////////////////////////////////////////////////////////
    //
    // Constructors
    //
    // ////////////////////////////////////////////////////////////////////////////////////
    public ListResponse() {
    }

    public ListResponse(List<?> list) {
        this.list = list;
    }

}
