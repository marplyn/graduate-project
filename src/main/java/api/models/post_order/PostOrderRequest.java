package api.models.post_order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class PostOrderRequest {

    private Long userId;

    private Integer tariffId;
}
