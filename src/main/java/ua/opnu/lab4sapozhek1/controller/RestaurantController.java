package ua.opnu.lab4sapozhek1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.lab4sapozhek1.dto.RestaurantRequestDto;
import ua.opnu.lab4sapozhek1.dto.RestaurantResponseDto;
import ua.opnu.lab4sapozhek1.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@Tag(
        name = "Ресторани",
        description = "Операції для роботи з ресторанами сервісу бронювання столиків"
)
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Operation(summary = "Створити ресторан", description = "Створює новий ресторан")
    @PostMapping
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@Valid @RequestBody RestaurantRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.create(dto));
    }

    @Operation(summary = "Отримати всі ресторани", description = "Повертає список усіх ресторанів")
    @GetMapping
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.findAll());
    }

    @Operation(summary = "Отримати ресторан за id", description = "Повертає ресторан за унікальним ідентифікатором")
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.findById(id));
    }

    @Operation(summary = "Оновити ресторан", description = "Оновлює дані ресторану")
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(
            @PathVariable Long id,
            @Valid @RequestBody RestaurantRequestDto dto
    ) {
        return ResponseEntity.ok(restaurantService.update(id, dto));
    }

    @Operation(summary = "Видалити ресторан", description = "Видаляє ресторан за id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
