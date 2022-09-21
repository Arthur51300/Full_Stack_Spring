package fr.polytech.fsback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.polytech.fsback.entity.GuideEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class GuideDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("restaurants")
    private List<RestaurantDto> restaurants;

    public static GuideDto fromEntity(GuideEntity entity) {
        return GuideDto.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .restaurants(entity.getRestaurants().stream().map(restaurant -> RestaurantDto.fromEntity(restaurant)).collect(Collectors.toList()))
                .build();
    }

}
