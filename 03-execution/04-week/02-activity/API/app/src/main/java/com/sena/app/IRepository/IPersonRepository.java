package com.sena.app.IRepository;

import com.sena.app.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);

    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    List<Person> findByAddress(String address);

    List<Person> findByPhone(String phone);

    List<Person> findByEmail(String email);

    List<Person> findByStatus(Boolean status);
}

