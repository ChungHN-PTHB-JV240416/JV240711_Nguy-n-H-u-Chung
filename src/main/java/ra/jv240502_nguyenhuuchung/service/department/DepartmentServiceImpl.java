package ra.jv240502_nguyenhuuchung.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Department;
import ra.jv240502_nguyenhuuchung.repository.DepartmentRepository;
import ra.jv240502_nguyenhuuchung.service.CloudinaryService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        if (departmentRepository.existsByName(department.getName())) {
            throw new RuntimeException("Tên phòng ban đã tồn tại");
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        return departmentRepository.findById(id).map(existing -> {
            existing.setName(department.getName());
            existing.setDescription(department.getDescription());
            existing.setStatus(department.isStatus());
            return departmentRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Phòng ban không tồn tại"));
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Phòng ban không tồn tại");
        }
        departmentRepository.deleteById(id);
    }
}
