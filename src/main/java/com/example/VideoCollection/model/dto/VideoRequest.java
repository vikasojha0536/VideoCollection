package com.example.VideoCollection.model.dto;

import com.example.VideoCollection.model.entity.Video;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoRequest {
    @JsonProperty("videoName")
    private String name;

    private BigDecimal price;

    private int year;

    public Video toEntity() {
        return Video.builder()
                .name(name)
                .price(price)
                .year(year)
                .build();
    }
}
