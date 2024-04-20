package api.models.post_order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.*;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostOrderResponse {

    private String orderId;

    public static PostOrderResponse createFrom(Response response) {
        return response.getBody().as(PostOrderResponse.class);
    }
}
