package api.models.get_tariffs;

import lombok.*;

@Getter
@ToString
public class TariffResponse {

    private Integer id;

    private String type;

    private String interestRate;
}
