package su.aleksokol3.spring.simplecrudserviceexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeCreateEditDto;
import su.aleksokol3.spring.simplecrudserviceexample.dto.EmployeeReadDto;
import su.aleksokol3.spring.simplecrudserviceexample.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeReadDto> findAll() {
        return employeeService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeReadDto findById(@PathVariable Long id) {
        return employeeService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeReadDto create(@RequestBody EmployeeCreateEditDto dto) {
        return employeeService.create(dto);
    }

    @PutMapping("/{id}")
    public EmployeeReadDto update(@PathVariable Long id, @RequestBody EmployeeCreateEditDto dto) {
        return employeeService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!employeeService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
