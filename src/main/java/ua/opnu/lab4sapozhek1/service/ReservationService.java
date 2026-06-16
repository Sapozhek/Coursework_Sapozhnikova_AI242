package ua.opnu.lab4sapozhek1.service;

import org.springframework.stereotype.Service;
import ua.opnu.lab4sapozhek1.dto.ReservationRequestDto;
import ua.opnu.lab4sapozhek1.dto.ReservationResponseDto;
import ua.opnu.lab4sapozhek1.exception.BadRequestException;
import ua.opnu.lab4sapozhek1.exception.ResourceNotFoundException;
import ua.opnu.lab4sapozhek1.model.Customer;
import ua.opnu.lab4sapozhek1.model.Reservation;
import ua.opnu.lab4sapozhek1.model.Restaurant;
import ua.opnu.lab4sapozhek1.model.RestaurantTable;
import ua.opnu.lab4sapozhek1.repository.CustomerRepository;
import ua.opnu.lab4sapozhek1.repository.ReservationRepository;
import ua.opnu.lab4sapozhek1.repository.RestaurantRepository;
import ua.opnu.lab4sapozhek1.repository.RestaurantTableRepository;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantTableRepository restaurantTableRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              CustomerRepository customerRepository,
                              RestaurantRepository restaurantRepository,
                              RestaurantTableRepository restaurantTableRepository) {
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public List<ReservationResponseDto> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public ReservationResponseDto findById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " not found"));

        return toResponseDto(reservation);
    }

    public ReservationResponseDto create(ReservationRequestDto dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + dto.getCustomerId() + " not found"));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + dto.getRestaurantId() + " not found"));

        RestaurantTable table = restaurantTableRepository.findById(dto.getTableId())
                .orElseThrow(() -> new ResourceNotFoundException("Table with id " + dto.getTableId() + " not found"));

        if (table.getRestaurant() != null && !table.getRestaurant().getId().equals(restaurant.getId())) {
            throw new BadRequestException("Selected table does not belong to selected restaurant");
        }

        Reservation reservation = new Reservation();
        reservation.setReservationTime(dto.getReservationTime());
        reservation.setGuestsCount(dto.getGuestsCount());
        reservation.setStatus(dto.getStatus());
        reservation.setCustomer(customer);
        reservation.setRestaurant(restaurant);
        reservation.setTable(table);

        Reservation savedReservation = reservationRepository.save(reservation);
        return toResponseDto(savedReservation);
    }

    public ReservationResponseDto update(Long id, ReservationRequestDto dto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " not found"));

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + dto.getCustomerId() + " not found"));

        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant with id " + dto.getRestaurantId() + " not found"));

        RestaurantTable table = restaurantTableRepository.findById(dto.getTableId())
                .orElseThrow(() -> new ResourceNotFoundException("Table with id " + dto.getTableId() + " not found"));

        if (table.getRestaurant() != null && !table.getRestaurant().getId().equals(restaurant.getId())) {
            throw new BadRequestException("Selected table does not belong to selected restaurant");
        }

        reservation.setReservationTime(dto.getReservationTime());
        reservation.setGuestsCount(dto.getGuestsCount());
        reservation.setStatus(dto.getStatus());
        reservation.setCustomer(customer);
        reservation.setRestaurant(restaurant);
        reservation.setTable(table);

        Reservation updatedReservation = reservationRepository.save(reservation);
        return toResponseDto(updatedReservation);
    }

    public void deleteById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation with id " + id + " not found"));

        reservationRepository.delete(reservation);
    }

    public List<ReservationResponseDto> findByCustomerId(Long customerId) {
        customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));

        return reservationRepository.findAll()
                .stream()
                .filter(reservation -> reservation.getCustomer() != null
                        && reservation.getCustomer().getId().equals(customerId))
                .map(this::toResponseDto)
                .toList();
    }

    private ReservationResponseDto toResponseDto(Reservation reservation) {
        Long customerId = reservation.getCustomer() != null ? reservation.getCustomer().getId() : null;
        Long restaurantId = reservation.getRestaurant() != null ? reservation.getRestaurant().getId() : null;
        Long tableId = reservation.getTable() != null ? reservation.getTable().getId() : null;

        return new ReservationResponseDto(
                reservation.getId(),
                reservation.getReservationTime(),
                reservation.getGuestsCount(),
                reservation.getStatus(),
                customerId,
                restaurantId,
                tableId
        );
    }
}