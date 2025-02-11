package ra.jv240502_nguyenhuuchung.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @Column(length = 5)
    private Long empId;

    @ManyToOne
    @JoinColumn(name = "Dept_id", nullable = false)
    private Department department;

    @Column(name = "Emp_name", nullable = false, length = 100)
    private String empName;

    @Column(name = "Emp_BirthOfDate", nullable = false)
    private Date empBirthOfDate;

    @Column(name = "Emp_Sex", nullable = false)
    private Boolean empSex;

    @Column(name = "Emp_address", nullable = false)
    private String empAddress;

    @Column(name = "Emp_email", nullable = false, unique = true, length = 199)
    private String empEmail;

    @Column(name = "Emp_phone", nullable = false, unique = true, length = 11)
    private String empPhone;

    @Column(name = "Emp_avatar")
    private String empAvatar;

    @Column(name = "Emp_status", columnDefinition = "BIT DEFAULT 1")
    private Boolean empStatus = true;
}
