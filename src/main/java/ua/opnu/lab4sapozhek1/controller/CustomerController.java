package ua.opnu.lab4sapozhek1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.lab4sapozhek1.dto.CustomerRequestDto;
import ua.opnu.lab4sapozhek1.dto.CustomerResponseDto;
import ua.opnu.lab4sapozhek1.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(
        name = "Клієнти",
        description = "Операції для роботи з клієнтами сервісу бронювання столиків"
)
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Створити клієнта", description = "Створює нового клієнта")
    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(dto));
    }

    @Operation(summary = "Отримати всіх клієнтів", description = "Повертає список усіх клієнтів")
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @Operation(summary = "Отримати клієнта за id", description = "Повертає клієнта за унікальним ідентифікатором")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @Operation(summary = "Оновити клієнта", description = "Оновлює дані клієнта")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(
            @PathVariable Long id,
            @Valid @RequestBody CustomerRequestDto dto
    ) {
        return ResponseEntity.ok(customerService.update(id, dto));
    }

    @Operation(summary = "Видалити клієнта", description = "Видаляє клієнта за id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
