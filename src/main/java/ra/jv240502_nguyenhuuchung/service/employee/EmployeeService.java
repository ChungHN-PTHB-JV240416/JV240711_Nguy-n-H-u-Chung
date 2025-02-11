package ra.jv240502_nguyenhuuchung.service.employee;

import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(String name, String email, String phone, MultipartFile file) throws IOException;
    Employee updateEmployee(Long id, String name, String email, String phone, MultipartFile file) throws IOException;
    void deleteEmployee(Long id);
    }


