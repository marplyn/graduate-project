package api.models.delete_order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class DeleteOrderPayload {

    private Long userId;

    private String orderId;
}
