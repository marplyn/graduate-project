package api.models.get_tariffs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@ToString
public class Tariff {

    private Integer id;

    private String type;

    @JsonProperty("interest_rate")
    private String interestRate;
}
