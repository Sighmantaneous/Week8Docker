package ie.atu.jpaweek7;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "persons")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String employeeId;
    @NotBlank
    private String position;
    @NotBlank
    private String department;
}