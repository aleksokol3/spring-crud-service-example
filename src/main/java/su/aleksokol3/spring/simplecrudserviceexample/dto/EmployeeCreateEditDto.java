package su.aleksokol3.spring.simplecrudserviceexample.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record EmployeeCreateEditDto(String firstName, String lastName, Integer age, BigDecimal salary) {
}
