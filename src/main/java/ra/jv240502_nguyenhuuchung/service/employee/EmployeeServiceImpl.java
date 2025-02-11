package ra.jv240502_nguyenhuuchung.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Employee;
import ra.jv240502_nguyenhuuchung.repository.EmployeeRepository;
import ra.jv240502_nguyenhuuchung.service.CloudinaryService;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        existing.setEmpName(employee.getEmpName());
        existing.setEmpBirthOfDate(employee.getEmpBirthOfDate());
        existing.setEmpSex(employee.getEmpSex());
        existing.setEmpAddress(employee.getEmpAddress());
        existing.setEmpEmail(employee.getEmpEmail());
        existing.setEmpPhone(employee.getEmpPhone());
        existing.setEmpStatus(employee.getEmpStatus());

        return employeeRepository.save(existing);
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
        employee.setEmpStatus(false);
        employeeRepository.save(employee);
    }

    @Override
    public Employee uploadEmployeeAvatar(String id, MultipartFile file) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

        String imageUrl = cloudinaryService.uploadFile(file);
        employee.setEmpAvatar(imageUrl);

        return employeeRepository.save(employee);
    }
}
