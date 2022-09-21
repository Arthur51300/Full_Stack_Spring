package fr.polytech.fsback.service;

import fr.polytech.fsback.entity.EvaluationEntity;
import fr.polytech.fsback.entity.RestaurantEntity;
import fr.polytech.fsback.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;

    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int restaurantId, String messageDuCommentaire) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity nouveauCommentaire = EvaluationEntity.builder().message(messageDuCommentaire).restaurant(restaurant).build();

        return this.evaluationRepository.save(nouveauCommentaire);
    }

}
