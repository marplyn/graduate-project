package api.models.delete_order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class DeleteOrderRequest {

    private Long userId;

    private String orderId;
}
