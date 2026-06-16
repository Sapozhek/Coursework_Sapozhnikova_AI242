package ua.opnu.lab4sapozhek1.repository;

import ua.opnu.lab4sapozhek1.model.Customer;
import ua.opnu.lab4sapozhek1.model.Reservation;
import ua.opnu.lab4sapozhek1.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomer(Customer customer);
    List<Reservation> findByStatus(ReservationStatus status);
}