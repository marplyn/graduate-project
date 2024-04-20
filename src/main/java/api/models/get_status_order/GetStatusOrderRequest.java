package api.models.get_status_order;

import api.models.CommonRequest;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class GetStatusOrderRequest extends CommonRequest {

    private String orderId;
}
