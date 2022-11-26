package DH.back_integrador.controller;

import DH.back_integrador.dto.ProductDTO;
import DH.back_integrador.exceptions.BadRequestException;
import DH.back_integrador.exceptions.ResourceNotFoundException;
import DH.back_integrador.model.City;
import DH.back_integrador.model.Roles;
import DH.back_integrador.model.Users;
import DH.back_integrador.repository.UsersRepository;
import DH.back_integrador.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserControllerTemp {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/publico/registro")
    public ResponseEntity<Users> saveUser(@RequestBody Users user) throws BadRequestException, ResourceNotFoundException {


        if (usersRepository.findByEmail(user.getEmail())!=null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "El email ya esta registrado");
        }

        //pisar el password por uno encriptado
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //poner Rol por defecto, se le pone el rol del id:1
        user.setRol(new Roles(1L));


        return new ResponseEntity<>(usersRepository.save(user), HttpStatus.CREATED);

    }



    @GetMapping("/getUserByToken")
    public ResponseEntity<Users> getUserToken(@RequestHeader(value="Authorization") String token) throws ResourceNotFoundException {

        return new ResponseEntity<>(userService.getUserByToker(token), HttpStatus.OK);
    }

}




