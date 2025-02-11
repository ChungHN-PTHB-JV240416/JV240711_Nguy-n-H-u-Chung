package ra.jv240502_nguyenhuuchung.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Employee;
import ra.jv240502_nguyenhuuchung.service.employee.EmployeeService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestParam("name") String name,
                                                @RequestParam("email") String email,
                                                @RequestParam("phone") String phone,
                                                @RequestParam("avatar") MultipartFile file) throws IOException {
        return ResponseEntity.ok(employeeService.addEmployee(name, email, phone, file));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("email") String email,
                                                   @RequestParam("phone") String phone,
                                                   @RequestParam(value = "avatar", required = false) MultipartFile file) throws IOException {
        return ResponseEntity.ok(employeeService.updateEmployee(id, name, email, phone, file));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Xóa nhân viên thành công");
    }
}
