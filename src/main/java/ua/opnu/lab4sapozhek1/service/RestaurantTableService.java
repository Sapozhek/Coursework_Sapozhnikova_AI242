package ua.opnu.lab4sapozhek1.service;

import org.springframework.stereotype.Service;
import ua.opnu.lab4sapozhek1.dto.RestaurantTableRequestDto;
import ua.opnu.lab4sapozhek1.dto.RestaurantTableResponseDto;
import ua.opnu.lab4sapozhek1.exception.ResourceNotFoundException;
import ua.opnu.lab4sapozhek1.model.Restaurant;
import ua.opnu.lab4sapozhek1.model.RestaurantTable;
import ua.opnu.lab4sapozhek1.model.TableType;
import ua.opnu.lab4sapozhek1.repository.RestaurantRepository;
import ua.opnu.lab4sapozhek1.repository.RestaurantTableRepository;
import ua.opnu.lab4sapozhek1.repository.TableTypeRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantRepository restaurantRepository;
    private final TableTypeRepository tableTypeRepository;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository,
                                  RestaurantRepository restaurantRepository,
                                  TableTypeRepository tableTypeRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantRepository = restaurantRepository;
        this.tableTypeRepository = tableTypeRepository;
    }

    public List<RestaurantTableResponseDto> findAll() {
        return restaurantTableRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public RestaurantTableResponseDto findById(Long id) {
        RestaurantTable table = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant table with id " + id + " not found"));

        return toResponseDto(table);
    }

    public RestaurantTableResponseDto create(RestaurantTableRequestDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + dto.getRestaurantId() + " not found"));

        Set<TableType> tableTypes = dto.getTableTypeIds().stream()
                .map(tableTypeId -> tableTypeRepository.findById(tableTypeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Table type with id " + tableTypeId + " not found")))
                .collect(Collectors.toSet());

        RestaurantTable table = new RestaurantTable();
        table.setNumber(dto.getNumber());
        table.setCapacity(dto.getCapacity());
        table.setRestaurant(restaurant);
        table.getTableTypes().addAll(tableTypes);

        RestaurantTable savedTable = restaurantTableRepository.save(table);
        return toResponseDto(savedTable);
    }

    public RestaurantTableResponseDto update(Long id, RestaurantTableRequestDto dto) {
        RestaurantTable table = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant table with id " + id + " not found"));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + dto.getRestaurantId() + " not found"));

        Set<TableType> tableTypes = dto.getTableTypeIds().stream()
                .map(tableTypeId -> tableTypeRepository.findById(tableTypeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Table type with id " + tableTypeId + " not found")))
                .collect(Collectors.toSet());

        table.setNumber(dto.getNumber());
        table.setCapacity(dto.getCapacity());
        table.setRestaurant(restaurant);
        table.getTableTypes().clear();
        table.getTableTypes().addAll(tableTypes);

        RestaurantTable updatedTable = restaurantTableRepository.save(table);
        return toResponseDto(updatedTable);
    }

    public void deleteById(Long id) {
        RestaurantTable table = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant table with id " + id + " not found"));

        restaurantTableRepository.delete(table);
    }

    private RestaurantTableResponseDto toResponseDto(RestaurantTable table) {
        Set<Long> tableTypeIds = table.getTableTypes().stream()
                .map(TableType::getId)
                .collect(Collectors.toSet());

        Long restaurantId = table.getRestaurant() != null ? table.getRestaurant().getId() : null;

        return new RestaurantTableResponseDto(
                table.getId(),
                table.getNumber(),
                table.getCapacity(),
                restaurantId,
                tableTypeIds
        );
    }
}