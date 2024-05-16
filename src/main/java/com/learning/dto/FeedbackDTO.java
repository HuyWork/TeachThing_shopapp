package com.learning.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FeedbackDTO {
    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("rate")
    private int rate;
}
