package ua.ithillel.bank.person;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ua.ithillel.bank.entity.BaseEntity;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
@EntityListeners(AuditingEntityListener.class)
public class Person extends BaseEntity {
    private String uid;
    private String name;
    private String email;
}
