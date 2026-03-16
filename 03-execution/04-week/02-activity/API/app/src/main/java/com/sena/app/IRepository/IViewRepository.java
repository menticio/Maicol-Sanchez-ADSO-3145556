package com.sena.app.IRepository;

import com.sena.app.Entity.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IViewRepository extends JpaRepository<View, Long> {
    Optional<View> findById(Long id);

    List<View> findByName(String name);
}

