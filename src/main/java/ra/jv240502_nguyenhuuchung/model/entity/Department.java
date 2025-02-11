package ra.jv240502_nguyenhuuchung.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    @Column(name = "Dept_Name", unique = true, nullable = false, length = 99)
    private String deptName;

    @Column(name = "Dept_description")
    private String deptDescription;

    @Column(name = "Dept_status", columnDefinition = "BIT DEFAULT 1")
    private boolean deptStatus = true;

    @Column(name = "image")
    private String profileImage;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees;
}
