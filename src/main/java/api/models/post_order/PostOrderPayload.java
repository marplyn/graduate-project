package api.models.post_order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(setterPrefix = "set", toBuilder = true)
public class PostOrderPayload {

    @Builder.Default
    private Long userId = 34566546L;

    @Builder.Default
    private Integer tariffId = 1;
}
