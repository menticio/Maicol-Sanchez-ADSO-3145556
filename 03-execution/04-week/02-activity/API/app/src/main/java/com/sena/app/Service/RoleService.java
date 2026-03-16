package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.app.Entity.Role;
import com.sena.app.IRepository.IRoleRepository;

@Service
public class RoleService {
    @Autowired
    private IRoleRepository repository;

    public Role save(Role role){
        return repository.save(role);
    }

    public List<Role> getAllRoles(){
        return repository.findAll();
    }

    public Optional<Role> getRoleById(Long id){
        return repository.findById(id);
    }

    public List<Role> getRoleByName(String name){
        return repository.findByName(name);
    }

    public Role update(Long id, Role role){
        Optional<Role> roleData= repository.findById(id);
        
        if(roleData.isPresent()){
            Role existingRole= roleData.get();

            existingRole.setName(role.getName());
            existingRole.setDescription(role.getDescription());
            return repository.save(existingRole);
        }   
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
