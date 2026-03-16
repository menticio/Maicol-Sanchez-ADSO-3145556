package com.sena.app.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.app.Entity.Person;
import com.sena.app.Service.PersonService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person savedPerson = service.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll() {       
        List<Person> people = service.getAllPeople();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Person> searchPeople(
        @RequestParam(required=false) String firstName,
        @RequestParam(required=false) String lastName,
        @RequestParam(required=false) String address,
        @RequestParam(required=false) String phone,
        @RequestParam(required=false) String email,
        @RequestParam(required=false) Boolean status){
    if(firstName !=null){
        return service.getPersonByFirstName(firstName);
    }
    if(lastName != null){
        return service.getPersonByLastName(lastName);
    }
    if(address != null){
        return service.getPersonByAddress(address);
    }
    if(phone != null){
        return service.getPersonByPhone(phone);
    }
    if(email != null){
        return service.getPersonByEmail(email);
    }
    if(status !=null){
        return service.getPersonByStatus(status);
    }
    return service.getAllPeople();

    }

    @GetMapping("/searchId")
    public Optional<Person> getById(@RequestParam Long id){
        return service.getPersonById(id);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id){
        service.delete(id);
        return "Persona eliminada correctamente";
    }

    

}
