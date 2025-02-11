package ra.jv240502_nguyenhuuchung.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "status", columnDefinition = "BIT DEFAULT 1")
    private boolean status = true; // 1: Đang làm, 0: Nghỉ việc

    @Column(name = "avatar_url")
    private String avatarUrl; // Link ảnh từ Cloudinary

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
