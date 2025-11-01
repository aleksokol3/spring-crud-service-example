package su.aleksokol3.spring.simplecrudserviceexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeCreateEditDto;
import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeReadDto;
import su.aleksokol3.spring.simplecrudserviceexample.entity.Employee;
import su.aleksokol3.spring.simplecrudserviceexample.mapper.EmployeeMapper;
import su.aleksokol3.spring.simplecrudserviceexample.repository.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private static final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;

    public List<EmployeeReadDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::entityToDto)
                .toList();
    }
    public Optional<EmployeeReadDto> findById(Long id) {
        return employeeRepository.findById(id).map(employeeMapper::entityToDto);
    }
    public EmployeeReadDto create(EmployeeCreateEditDto employeeDto) {
        Employee employee = employeeMapper.dtoToEntity(employeeDto);
        employee.setHiringDate(LocalDateTime.now());
        employeeRepository.saveAndFlush(employee);
        return employeeMapper.entityToDto(employee);
    }
    public EmployeeReadDto update(Long id, EmployeeCreateEditDto dto) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isPresent()) {
            Employee updatedEmployee = optEmployee.map(
                    employee -> {
                        if (dto.firstName() != null) employee.setFirstName(dto.firstName());
                        if (dto.lastName() != null) employee.setLastName(dto.lastName());
                        if (dto.age() != null) employee.setAge(dto.age());
                        if (dto.salary() != null) employee.setSalary(dto.salary());
                        employeeRepository.save(employee);
                        return employee;
                    }
            ).get();
            return employeeMapper.entityToDto(updatedEmployee);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (employeeRepository.findById(id).isEmpty()) return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
