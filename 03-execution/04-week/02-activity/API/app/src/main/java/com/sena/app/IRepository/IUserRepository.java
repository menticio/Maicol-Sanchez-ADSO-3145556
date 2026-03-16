package com.sena.app.IRepository;

import com.sena.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    List<User> findByName(String name);



}
