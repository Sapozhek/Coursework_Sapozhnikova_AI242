package ua.opnu.lab4sapozhek1.service;

import org.springframework.stereotype.Service;
import ua.opnu.lab4sapozhek1.dto.CustomerRequestDto;
import ua.opnu.lab4sapozhek1.dto.CustomerResponseDto;
import ua.opnu.lab4sapozhek1.exception.ResourceNotFoundException;
import ua.opnu.lab4sapozhek1.model.Customer;
import ua.opnu.lab4sapozhek1.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponseDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public CustomerResponseDto findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));

        return toResponseDto(customer);
    }

    public CustomerResponseDto create(CustomerRequestDto dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        Customer savedCustomer = customerRepository.save(customer);
        return toResponseDto(savedCustomer);
    }

    public CustomerResponseDto update(Long id, CustomerRequestDto dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));

        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());

        Customer updatedCustomer = customerRepository.save(customer);
        return toResponseDto(updatedCustomer);
    }

    public void deleteById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));

        customerRepository.delete(customer);
    }

    private CustomerResponseDto toResponseDto(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }
}