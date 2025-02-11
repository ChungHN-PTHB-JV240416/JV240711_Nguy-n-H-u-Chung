package ra.jv240502_nguyenhuuchung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.jv240502_nguyenhuuchung.model.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByDeptName(String deptName);
}
