package ra.jv240502_nguyenhuuchung.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ra.jv240502_nguyenhuuchung.model.entity.Department;
import ra.jv240502_nguyenhuuchung.repository.DepartmentRepository;
import ra.jv240502_nguyenhuuchung.service.department.DepartmentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {
    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody Department department) {
        if (departmentRepository.existsByName(department.getName())) {
            return ResponseEntity.badRequest().body("Tên phòng ban đã tồn tại");
        }
        departmentRepository.save(department);
        return ResponseEntity.ok("Thêm phòng ban thành công");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentRepository.findById(id).map(existing -> {
            existing.setName(department.getName());
            existing.setDescription(department.getDescription());
            existing.setStatus(department.isStatus());
            departmentRepository.save(existing);
            return ResponseEntity.ok("Cập nhật phòng ban thành công");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return ResponseEntity.ok("Xóa phòng ban thành công");
        }
        return ResponseEntity.notFound().build();
    }
}
