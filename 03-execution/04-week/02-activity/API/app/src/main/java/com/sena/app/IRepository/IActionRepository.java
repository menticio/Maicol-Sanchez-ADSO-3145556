package com.sena.app.IRepository;

import com.sena.app.Entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IActionRepository extends JpaRepository<Action, Long> {
    Optional<Action> findById(Long id);

    List<Action> findByName(String name);

    List<Action> findByAction(String action);
}

