package ra.jv240502_nguyenhuuchung.service.employee;

import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

        List<Employee> getAllEmployees();
        Employee createEmployee(Employee employee);
        Employee updateEmployee(String id, Employee employee);
        void deleteEmployee(String id);
        Employee uploadEmployeeAvatar(String id, MultipartFile file);
    }


