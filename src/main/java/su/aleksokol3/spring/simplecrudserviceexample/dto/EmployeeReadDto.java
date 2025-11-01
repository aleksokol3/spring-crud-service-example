package su.aleksokol3.spring.simplecrudserviceexample.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record EmployeeReadDto(Long id, String firstName, String lastName, Integer age, BigDecimal salary, LocalDateTime hiringDate) {
}
