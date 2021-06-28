package com.ranjan.api.footballapi.model;

import lombok.*;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    private Long id;
    private String name;
    private String code;
    private String imageUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id.equals(country.id) && code.equals(country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
