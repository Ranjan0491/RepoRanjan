package com.ranjan.api.footballapi.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Competition {
    private Long id;
    private String name;
    private String code;
    private String plan;
    private Country country;
    private LocalDateTime lastUpdated;
}
