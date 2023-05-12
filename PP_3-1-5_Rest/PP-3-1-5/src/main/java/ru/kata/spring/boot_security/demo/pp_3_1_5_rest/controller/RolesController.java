package ru.kata.spring.boot_security.demo.pp_3_1_5_rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.pp_3_1_5_rest.model.Role;
import ru.kata.spring.boot_security.demo.pp_3_1_5_rest.model.User;
import ru.kata.spring.boot_security.demo.pp_3_1_5_rest.service.RoleService;
import ru.kata.spring.boot_security.demo.pp_3_1_5_rest.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class RolesController {

    private final RoleService roleService;

    public RolesController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public ResponseEntity<Set<Role>> getAllRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/roles/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable("id") long id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }
}


