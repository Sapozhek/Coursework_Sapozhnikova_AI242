package ua.opnu.lab4sapozhek1.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.lab4sapozhek1.dto.RestaurantTableRequestDto;
import ua.opnu.lab4sapozhek1.dto.RestaurantTableResponseDto;
import ua.opnu.lab4sapozhek1.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@Hidden
@RestController
@RequestMapping("/tables")
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping
    public ResponseEntity<RestaurantTableResponseDto> createTable(@Valid @RequestBody RestaurantTableRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantTableService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantTableResponseDto>> getAllTables() {
        return ResponseEntity.ok(restaurantTableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTableResponseDto> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantTableService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTableResponseDto> updateTable(@PathVariable Long id,
                                                                  @Valid @RequestBody RestaurantTableRequestDto dto) {
        return ResponseEntity.ok(restaurantTableService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        restaurantTableService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}