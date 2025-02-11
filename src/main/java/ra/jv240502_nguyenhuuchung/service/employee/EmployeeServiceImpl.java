package ra.jv240502_nguyenhuuchung.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Employee;
import ra.jv240502_nguyenhuuchung.repository.EmployeeRepository;
import ra.jv240502_nguyenhuuchung.service.CloudinaryService;

import java.io.IOException;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final CloudinaryService cloudinaryService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CloudinaryService cloudinaryService) {
        this.employeeRepository = employeeRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(String name, String email, String phone, MultipartFile file) throws IOException {
        String avatarUrl = cloudinaryService.uploadFile(file);
        Employee employee = new Employee(null, name, email, phone, true, avatarUrl, null);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, String name, String email, String phone, MultipartFile file) throws IOException {
        return employeeRepository.findById(id).map(existing -> {
            existing.setName(name);
            existing.setEmail(email);
            existing.setPhone(phone);
            if (file != null && !file.isEmpty()) {
                try {
                    String newAvatarUrl = cloudinaryService.uploadFile(file);
                    existing.setAvatarUrl(newAvatarUrl);
                } catch (IOException e) {
                    throw new RuntimeException("Lỗi khi upload ảnh");
                }
            }
            return employeeRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Nhân viên không tồn tại");
        }
        employeeRepository.deleteById(id);
    }
}
