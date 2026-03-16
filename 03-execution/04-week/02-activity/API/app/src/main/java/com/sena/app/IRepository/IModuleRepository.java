package com.sena.app.IRepository;

import com.sena.app.Entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IModuleRepository extends JpaRepository<Module, Long> {
    Optional<Module> findById(Long id);

    List<Module> findByName(String name);
}

