package fr.polytech.fsback.controllers;

import fr.polytech.fsback.dto.RestaurantDto;
import fr.polytech.fsback.service.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
//@RequiredArgsConstructor
@Slf4j
public class RestaurantsController {
    public final RestaurantService restaurantService; //final : indiq pour dire que ça change pas plus tard (constante et pas variable)

    public RestaurantsController(RestaurantService rservice) {
        this.restaurantService = rservice;
    }

    @GetMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id) {
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }


    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurant() {
        System.out.println("retourne tous les restaurants");
        return this.restaurantService.getAllRestaurants().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("/restaurants")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto r) {
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(r.getNom(),r.getAdresse()));
    }

   /*
    @PutMapping("/restaurants")
    public RestaurantDto putRestaurant(@PathVariable RestaurantDto r) {
        return RestaurantDto.fromEntity(this.restaurantService.updateRestaurant(r.setNom(),r.setAdresse()));
    }

    */

}
