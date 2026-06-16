package ua.opnu.lab4sapozhek1.service;

import org.springframework.stereotype.Service;
import ua.opnu.lab4sapozhek1.dto.TableTypeRequestDto;
import ua.opnu.lab4sapozhek1.dto.TableTypeResponseDto;
import ua.opnu.lab4sapozhek1.exception.ResourceNotFoundException;
import ua.opnu.lab4sapozhek1.model.TableType;
import ua.opnu.lab4sapozhek1.repository.TableTypeRepository;

import java.util.List;

@Service
public class TableTypeService {

    private final TableTypeRepository tableTypeRepository;

    public TableTypeService(TableTypeRepository tableTypeRepository) {
        this.tableTypeRepository = tableTypeRepository;
    }

    public List<TableTypeResponseDto> findAll() {
        return tableTypeRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public TableTypeResponseDto findById(Long id) {
        TableType tableType = tableTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table type with id " + id + " not found"));

        return toResponseDto(tableType);
    }

    public TableTypeResponseDto create(TableTypeRequestDto dto) {
        TableType tableType = new TableType();
        tableType.setName(dto.getName());
        tableType.setDescription(dto.getDescription());

        TableType savedTableType = tableTypeRepository.save(tableType);
        return toResponseDto(savedTableType);
    }

    public TableTypeResponseDto update(Long id, TableTypeRequestDto dto) {
        TableType tableType = tableTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table type with id " + id + " not found"));

        tableType.setName(dto.getName());
        tableType.setDescription(dto.getDescription());

        TableType updatedTableType = tableTypeRepository.save(tableType);
        return toResponseDto(updatedTableType);
    }

    public void deleteById(Long id) {
        TableType tableType = tableTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Table type with id " + id + " not found"));

        tableTypeRepository.delete(tableType);
    }

    private TableTypeResponseDto toResponseDto(TableType tableType) {
        return new TableTypeResponseDto(
                tableType.getId(),
                tableType.getName(),
                tableType.getDescription()
        );
    }
}