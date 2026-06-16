package ua.opnu.lab4sapozhek1.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.lab4sapozhek1.dto.TableTypeRequestDto;
import ua.opnu.lab4sapozhek1.dto.TableTypeResponseDto;
import ua.opnu.lab4sapozhek1.service.TableTypeService;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@Hidden
@RestController
@RequestMapping("/table-types")
public class TableTypeController {

    private final TableTypeService tableTypeService;

    public TableTypeController(TableTypeService tableTypeService) {
        this.tableTypeService = tableTypeService;
    }

    @PostMapping
    public ResponseEntity<TableTypeResponseDto> createTableType(@Valid @RequestBody TableTypeRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tableTypeService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<TableTypeResponseDto>> getAllTableTypes() {
        return ResponseEntity.ok(tableTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableTypeResponseDto> getTableTypeById(@PathVariable Long id) {
        return ResponseEntity.ok(tableTypeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableTypeResponseDto> updateTableType(@PathVariable Long id,
                                                                @Valid @RequestBody TableTypeRequestDto dto) {
        return ResponseEntity.ok(tableTypeService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTableType(@PathVariable Long id) {
        tableTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}