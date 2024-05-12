package api.models.get_status_order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.restassured.response.Response;
import lombok.*;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("data")
public class GetStatusOrderResponse {

    private String orderStatus;

    public static GetStatusOrderResponse createFrom(Response response) {
        return response.getBody().as(GetStatusOrderResponse.class);
    }
}
