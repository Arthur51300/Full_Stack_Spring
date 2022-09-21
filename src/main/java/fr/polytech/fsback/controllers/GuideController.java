package fr.polytech.fsback.controllers;

import fr.polytech.fsback.dto.GuideDto;
import fr.polytech.fsback.dto.RestaurantDto;
import fr.polytech.fsback.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class GuideController {

    private final GuideService guideService;

    @GetMapping("/guides/{id}")
    public @ResponseBody GuideDto getGuidesById(@PathVariable final int id) {
        return GuideDto.fromEntity(this.guideService.getGuideById(id));
    }

    @PostMapping("/bibliotheques/{bibliothequeId}/livres")
    public void addRestaurantToGuide(@PathVariable final int guideId, @RequestBody @Valid final RestaurantDto restaurant) {
        this.guideService.addRestaurantToGuide(guideId, restaurant.getId());
    }

}
