package api.models.get_status_order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.*;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStatusOrderResponse {

    private String orderStatus;

    public static GetStatusOrderResponse createFrom(Response response) {
        return response.getBody().as(GetStatusOrderResponse.class);
    }
}
