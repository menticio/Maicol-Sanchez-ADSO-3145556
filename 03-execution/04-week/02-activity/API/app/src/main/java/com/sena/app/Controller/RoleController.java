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

import com.sena.app.Entity.Role;
import com.sena.app.Service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService service;

    public RoleController(RoleService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role role){
        Role savedRole= service.save(role);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roles= service.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Role> searchRoles(@RequestParam(required = false) String name ){
        if(name != null){
            return  service.getRoleByName(name);
        }
        return service.getAllRoles();
    }

    @GetMapping("/searchId")
    public Optional<Role> getById(@RequestParam Long id){
        return service.getRoleById(id);
    }

    @PutMapping("/{id}")
    public Role updaRole(@PathVariable Long id, @RequestBody Role role){
        return service.update(id, role);
    }

    @DeleteMapping
    public String deleteRole(@RequestBody Long id){
        service.delete(id);
        return "El rol fue eliminado exitosamente";
    }
}
