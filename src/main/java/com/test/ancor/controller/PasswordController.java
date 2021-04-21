package com.test.ancor.controller;

import com.test.ancor.model.Password;
import com.test.ancor.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {
    @Autowired
    private PasswordRepository passwordRepository;

    @PostMapping(path = "/save")
    private String  savePassword(@RequestBody Password password){
        passwordRepository.save(password);
        return "Saved";
    }

    @GetMapping("/get/{id}")
    private Password getPassword(@PathVariable Long id){
        return passwordRepository.findById(id).get();
    }


    @GetMapping("/getAll")
    private List<Password> getPasswords(){
        return (List<Password>) passwordRepository.findAll();
    }

}
