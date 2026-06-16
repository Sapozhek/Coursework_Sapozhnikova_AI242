package ua.opnu.lab4sapozhek1.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Map;

@Schema(description = "Стандартна структура відповіді сервера у разі помилки")
public class ErrorResponse {

    @Schema(description = "Час виникнення помилки", example = "2026-06-14T14:30:00")
    private LocalDateTime timestamp;

    @Schema(description = "HTTP-статус помилки", example = "400")
    private int status;

    @Schema(description = "Короткий опис помилки", example = "Validation failed")
    private String error;

    @Schema(description = "Мапа помилок валідації за полями")
    private Map<String, String> validationErrors;

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestamp, int status, String error, Map<String, String> validationErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.validationErrors = validationErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}