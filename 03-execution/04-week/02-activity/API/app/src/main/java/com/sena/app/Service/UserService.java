package com.sena.app.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.User;
import com.sena.app.IRepository.IUserRepository;



@Service
public class UserService {
    @Autowired
    private IUserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id){                                       
        return repository.findById(id);
    }

    public List<User> getUserByName(String name){
        return repository.findByName(name);
    }

    public User update(Long id, User user){
        Optional<User> userData= repository.findById(id);

        if(userData.isPresent()){
            User existingUser= userData.get();

            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());

            return repository.save(existingUser);
        }
        return null;

    }

    public void delete(Long id){
        repository.deleteById(id);
    }



}
