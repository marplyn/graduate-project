package api.models.get_status_order;

import api.models.CommonRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class GetStatusOrderRequest extends CommonRequest {

    @Builder.Default
    private String orderId = "989358ed-58b0-4eed-8a08-6825fc590c7f";
}
