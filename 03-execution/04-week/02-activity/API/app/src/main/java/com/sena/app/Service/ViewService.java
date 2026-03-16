package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.View;
import com.sena.app.IRepository.IViewRepository;

@Service
public class ViewService {
    @Autowired
    private IViewRepository repository;

    public View save(View view){
        return repository.save(view);
    }

    public List<View> getAll(){
        return repository.findAll();
    }

    public Optional<View> getById(Long id){
        return repository.findById(id);
    }

    public List<View> getByName(String name){
        return repository.findByName(name);
    }

    public View update(Long id, View view){
        Optional<View> viewData = repository.findById(id);

        if(viewData.isPresent()){
            View existing = viewData.get();
            existing.setName(view.getName());
            existing.setRoute(view.getRoute());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

