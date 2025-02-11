package ra.jv240502_nguyenhuuchung.service.department;


import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Department;

import java.util.List;
public interface DepartmentService {
    List<Department> getAllDepartments();
    Department addDepartment(Department department);
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
}
