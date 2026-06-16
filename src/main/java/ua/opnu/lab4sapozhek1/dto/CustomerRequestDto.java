package ua.opnu.lab4sapozhek1.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO для створення або оновлення клієнта")
public class CustomerRequestDto {

    @Schema(description = "Ім'я клієнта", example = "Анна")
    @NotBlank(message = "First name must not be blank")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters")
    private String firstName;

    @Schema(description = "Прізвище клієнта", example = "Сапожнікова")
    @NotBlank(message = "Last name must not be blank")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters")
    private String lastName;

    @Schema(description = "Електронна пошта", example = "anna@example.com")
    @Email(message = "Email format is invalid")
    private String email;

    @Schema(description = "Телефон", example = "+380991112233")
    @NotBlank(message = "Phone must not be blank")
    @Pattern(regexp = "^[+]?[0-9\\-() ]{7,20}$", message = "Phone format is invalid")
    private String phone;

    public CustomerRequestDto() {
    }

    public CustomerRequestDto(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}