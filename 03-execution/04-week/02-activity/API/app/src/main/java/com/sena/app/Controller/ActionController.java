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

import com.sena.app.Entity.Action;
import com.sena.app.Service.ActionService;

@RestController
@RequestMapping("/api/action")
public class ActionController {
    @Autowired
    private ActionService service;

    public ActionController(ActionService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Action> create(@RequestBody Action action){
        Action saved = service.save(action);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Action>> getAll(){
        List<Action> list = service.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<Action> search(@RequestParam(required = false) String name, @RequestParam String action){
        if(name != null){
            return service.getByName(name);
        }

        if(action != null){
            return service.getByAction(action);
        }

        return service.getAll();
    }

    @GetMapping("/searchId")
    public Optional<Action> getById(@RequestParam Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Action update(@PathVariable Long id, @RequestBody Action action){
        return service.update(id, action);
    }

    @DeleteMapping
    public String delete(@RequestBody Long id){
        service.delete(id);
        return "La acción fue eliminada exitosamente";
    }
}

