package api.models.get_tariffs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.response.Response;
import lombok.*;

import java.util.List;

@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTariffsResponse {

    private List<Tariff> tariffs;

    public GetTariffsResponse createFrom(Response response) {
       return response.body().as(GetTariffsResponse.class);
    }
}
