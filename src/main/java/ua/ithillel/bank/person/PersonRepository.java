package ua.ithillel.bank.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    Optional<Person> findByUid(String id);
    Page<Person> findByName(String name, Pageable pageable);
    Page<Person> findByEmail(String email, Pageable pageable);
    Page<Person> findByNameAndEmail(String name, String email, Pageable pageable);
}
