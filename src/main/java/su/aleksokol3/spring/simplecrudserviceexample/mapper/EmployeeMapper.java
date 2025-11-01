package su.aleksokol3.spring.simplecrudserviceexample.mapper;

import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeCreateEditDto;
import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeReadDto;
import su.aleksokol3.spring.simplecrudserviceexample.entity.Employee;

import java.time.LocalDateTime;

public class EmployeeMapper {
    public static final EmployeeMapper INSTANCE = new EmployeeMapper();

    public EmployeeReadDto entityToDto(Employee employee) {
        return EmployeeReadDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .age(employee.getAge())
                .salary(employee.getSalary())
                .hiringDate(employee.getHiringDate())
                .build();
    }
    public Employee dtoToEntity(EmployeeCreateEditDto dto) {
        return Employee.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .age(dto.age())
                .salary(dto.salary())
                .hiringDate(LocalDateTime.now())
                .build();
    }
}
