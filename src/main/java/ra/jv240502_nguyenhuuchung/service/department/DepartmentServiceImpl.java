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
    private final CloudinaryService cloudinaryService;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, CloudinaryService cloudinaryService) {
        this.departmentRepository = departmentRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setDeptId(id);
            return departmentRepository.save(department);
        }
        throw new RuntimeException("Department not found");
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
