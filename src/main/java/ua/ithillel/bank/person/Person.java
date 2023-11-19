package ua.ithillel.bank.person;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ua.ithillel.bank.entity.BaseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person extends BaseEntity {
    private String uid;
}
