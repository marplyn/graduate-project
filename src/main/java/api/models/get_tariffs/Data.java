package api.models.get_tariffs;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Data {
    List<TariffResponse> tariffs;
}
