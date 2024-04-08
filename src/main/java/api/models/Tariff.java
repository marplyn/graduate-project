package api.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tariff {
    private Integer id;
    private String type;
    @JsonProperty("interest_rate")
    private String interestRate;
}
