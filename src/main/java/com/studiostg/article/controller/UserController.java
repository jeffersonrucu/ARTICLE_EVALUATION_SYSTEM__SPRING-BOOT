package com.studiostg.article.controller;

import com.studiostg.article.model.bean.User;
import com.studiostg.article.model.dto.user.UserCreateDTO;
import com.studiostg.article.model.dto.user.UserUpdateDTO;
import com.studiostg.article.service.UserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity index() {
        return ResponseEntity.ok().body(service.index());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody UserCreateDTO user, UriComponentsBuilder uriBuilder) {
        User newUser = service.create(user);
        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(newUser.getId()).toUri();
        return ResponseEntity.created(uri).body(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity read(@PathVariable Long id) {
        Optional<User> user = service.read(id);

        if(!user.isPresent()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(service.read(id));
    }

    @PutMapping
    public ResponseEntity update(@Valid @RequestBody UserUpdateDTO userDTO, UriComponentsBuilder uriBuilder) {
        Optional<User> userNew = service.update(userDTO);

        if(!userNew.isPresent()) return ResponseEntity.notFound().build();

        URI uri = uriBuilder.path("/user/{id}").buildAndExpand(userNew.get().getId()).toUri();
        return ResponseEntity.created(uri).body(userNew.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);

        if(deleted) return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
