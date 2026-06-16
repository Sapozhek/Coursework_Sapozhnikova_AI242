package ua.opnu.lab4sapozhek1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @GetMapping("/restaurants/count")
    public ResponseEntity<String> getRestaurantsCount() {
        return ResponseEntity.ok("GET /analytics/restaurants/count OK");
    }

    @GetMapping("/customers/count")
    public ResponseEntity<String> getCustomersCount() {
        return ResponseEntity.ok("GET /analytics/customers/count OK");
    }

    @GetMapping("/reservations/active")
    public ResponseEntity<String> getActiveReservationsAnalytics() {
        return ResponseEntity.ok("GET /analytics/reservations/active OK");
    }

    @GetMapping("/reservations/completed")
    public ResponseEntity<String> getCompletedReservationsAnalytics() {
        return ResponseEntity.ok("GET /analytics/reservations/completed OK");
    }

    @GetMapping("/tables/by-type")
    public ResponseEntity<String> getTablesByType() {
        return ResponseEntity.ok("GET /analytics/tables/by-type OK");
    }
}