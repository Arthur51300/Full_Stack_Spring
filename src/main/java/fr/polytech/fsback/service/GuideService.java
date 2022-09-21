package fr.polytech.fsback.service;

import fr.polytech.fsback.entity.GuideEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.exception.ResourceDoesntExistException;
import fr.polytech.fsback.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuideService {

    private final RestaurantService restaurantService;
    private final GuideRepository guideRepository;

    public GuideEntity getGuideById(final int id) {
        return this.guideRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExistException("Guide with id " + id + " doesn't exists"));
    }

    public void addRestaurantToGuide(final int guideId, final int restaurantId) {
        final GuideEntity guide = this.getGuideById(guideId);
        final RestaurantEntity restaurantToAdd = this.restaurantService.getRestaurantById(restaurantId);

        guide.getRestaurants().add(restaurantToAdd);
        this.guideRepository.save(guide);
    }

}
