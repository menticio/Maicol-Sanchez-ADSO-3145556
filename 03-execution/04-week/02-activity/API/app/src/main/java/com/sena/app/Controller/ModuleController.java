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

import com.sena.app.Entity.Module;
import com.sena.app.Service.ModuleService;

@RestController
@RequestMapping("/api/module")
public class ModuleController {
    @Autowired
    private ModuleService service;

    public ModuleController(ModuleService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Module> create(@RequestBody Module module){
        Module saved = service.save(module);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Module>> getAll(){
        List<Module> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Module> search(@RequestParam(required = false) String name){
        if(name != null){
            return service.getByName(name);
        }
        return service.getAll();
    }

    @GetMapping("/searchId")
    public Optional<Module> getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Module update(@PathVariable Long id, @RequestBody Module module){
        return service.update(id, module);
    }

    @DeleteMapping
    public String delete(@RequestBody Long id){
        service.delete(id);
        return "El módulo fue eliminado exitosamente";
    }
}

