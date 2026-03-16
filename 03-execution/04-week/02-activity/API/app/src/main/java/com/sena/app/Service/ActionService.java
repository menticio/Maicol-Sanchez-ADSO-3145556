package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.Action;
import com.sena.app.IRepository.IActionRepository;

@Service
public class ActionService {
    @Autowired
    private IActionRepository repository;

    public Action save(Action action){
        return repository.save(action);
    }

    public List<Action> getAll(){
        return repository.findAll();
    }

    public Optional<Action> getById(Long id){
        return repository.findById(id);
    }

    public List<Action> getByAction(String action){
        return repository.findByAction(action);
    }

    public List<Action> getByName(String name){
        return repository.findByName(name);
    }

    public Action update(Long id, Action action){
        Optional<Action> actionData = repository.findById(id);

        if(actionData.isPresent()){
            Action existing = actionData.get();
            existing.setName(action.getName());
            existing.setAction(action.getAction());
            existing.setAffectTable(action.getAffectTable());
            existing.setDate(action.getDate());
            existing.setDescription(action.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

