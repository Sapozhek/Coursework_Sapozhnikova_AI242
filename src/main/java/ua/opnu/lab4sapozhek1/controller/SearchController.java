package ua.opnu.lab4sapozhek1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
@RequestMapping("/search")
public class SearchController {

    @GetMapping("/restaurants")
    public ResponseEntity<String> searchRestaurants(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/restaurants?query=" + query + " OK");
    }

    @GetMapping("/customers")
    public ResponseEntity<String> searchCustomers(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/customers?query=" + query + " OK");
    }

    @GetMapping("/reservations")
    public ResponseEntity<String> searchReservations(@RequestParam String query) {
        return ResponseEntity.ok("GET /search/reservations?query=" + query + " OK");
    }
}
