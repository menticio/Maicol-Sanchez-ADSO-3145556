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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.app.Entity.View;
import com.sena.app.Service.ViewService;

@RestController
@RequestMapping("/api/view")
public class ViewController {
    @Autowired
    private ViewService service;

    public ViewController(ViewService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<View> create(@RequestBody View view){
        View saved = service.save(view);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<View>> getAll(){
        List<View> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<View> search(@RequestParam(required = false) String name){
        if(name != null){
            return service.getByName(name);
        }
        return service.getAll();
    }

    @GetMapping("/searchId")
    public Optional<View> getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public View update(@PathVariable Long id, @RequestBody View view){
        return service.update(id, view);
    }

    @DeleteMapping
    public String delete(@RequestBody Long id){
        service.delete(id);
        return "La vista fue eliminada exitosamente";
    }
}

