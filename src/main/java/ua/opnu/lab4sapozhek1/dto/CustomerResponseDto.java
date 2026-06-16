package ua.opnu.lab4sapozhek1.dto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO відповіді з даними клієнта")
public class CustomerResponseDto {

    @Schema(description = "ID клієнта", example = "1")
    private Long id;

    @Schema(description = "Ім'я клієнта", example = "Анна")
    private String firstName;

    @Schema(description = "Прізвище клієнта", example = "Сапожнікова")
    private String lastName;

    @Schema(description = "Електронна пошта", example = "anna@example.com")
    private String email;

    @Schema(description = "Телефон", example = "+380991112233")
    private String phone;

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(Long id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


