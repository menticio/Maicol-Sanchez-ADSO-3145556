package com.sena.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.app.Entity.Person;
import com.sena.app.IRepository.IPersonRepository;

@Service
public class PersonService {
    @Autowired
    private IPersonRepository repository;

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> getAllPeople() {
        return repository.findAll();
    }

    public Optional<Person> getPersonById(Long id){
        return repository.findById(id);
    }

    public List<Person> getPersonByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }  
    
    public List<Person> getPersonByLastName(String lastName){
        return repository.findByLastName(lastName);
    }

    public List<Person> getPersonByAddress(String address){
        return repository.findByAddress(address);
    }

    public List<Person> getPersonByPhone(String phone){
        return repository.findByPhone(phone);
    }

    public List<Person> getPersonByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<Person> getPersonByStatus(Boolean status){
        return repository.findByStatus(status);
    }

    public Person update(Long id, Person person){
        Optional<Person> personData= repository.findById(id);

        if(personData.isPresent()){
            Person existingPerson= personData.get();
            
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setAddress(person.getAddress());
            existingPerson.setPhone(person.getPhone());
            existingPerson.setEmail(person.getEmail());
            existingPerson.setUpdatedAt(person.getUpdatedAt());
            existingPerson.setUpdatedBy(person.getUpdatedBy());

            return repository.save(existingPerson);
        }
        return null;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
