package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.Module;
import com.sena.app.IRepository.IModuleRepository;

@Service
public class ModuleService {
    @Autowired
    private IModuleRepository repository;

    public Module save(Module module){
        return repository.save(module);
    }

    public List<Module> getAll(){
        return repository.findAll();
    }

    public Optional<Module> getById(Long id){
        return repository.findById(id);
    }

    public List<Module> getByName(String name){
        return repository.findByName(name);
    }

    public Module update(Long id, Module module){
        Optional<Module> moduleData = repository.findById(id);

        if(moduleData.isPresent()){
            Module existing = moduleData.get();
            existing.setName(module.getName());
            existing.setDescription(module.getDescription());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}

