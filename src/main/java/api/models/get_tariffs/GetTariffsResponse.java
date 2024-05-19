package api.models.get_tariffs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import io.restassured.response.Response;
import lombok.*;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTariffsResponse {

    private Data data;

    public static GetTariffsResponse createFrom(Response response) {
       return response.getBody().as(GetTariffsResponse.class);
    }
}
