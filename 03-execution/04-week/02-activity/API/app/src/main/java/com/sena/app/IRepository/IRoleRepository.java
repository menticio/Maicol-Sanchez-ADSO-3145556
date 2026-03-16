package com.sena.app.IRepository;

import com.sena.app.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findById(Long id);

    List<Role> findByName(String name);
    
}
