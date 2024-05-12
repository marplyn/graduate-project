package api.models.delete_order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class DeleteOrderPayload {

    @Builder.Default
    private Long userId = 3453L;

    @Builder.Default
    private String orderId = "";
}
