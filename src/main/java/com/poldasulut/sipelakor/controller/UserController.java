package com.poldasulut.sipelakor.controller;

import com.poldasulut.sipelakor.getresponse.GetUserModel;
import com.poldasulut.sipelakor.model.UserModel;
import com.poldasulut.sipelakor.model.nofk.UserModels;
import com.poldasulut.sipelakor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public GetUserModel createPerson(@RequestParam int kotaKabupaten, @RequestParam  String nik, @RequestParam  String username,
                                     @RequestParam String jobs, @RequestParam  String address, @RequestParam String nomor, @RequestParam  String email, @RequestParam  String password,
                                     @RequestParam int status, @RequestParam String tanggalLahir) {
        GetUserModel getUserModel = new GetUserModel();
        UserModels userModel = userService.createUser(kotaKabupaten, nik, username,jobs, address, nomor, email, password,status,
                tanggalLahir);
        if (Objects.nonNull(userModel)) {
            getUserModel.setStatus("success");
            getUserModel.setUserModel(userModel);
            return getUserModel;
        }else {
            getUserModel.setStatus("failed");
            return getUserModel;
        }
    }

    @GetMapping("/person/{nikUser}")
    public UserModels getUserByNikUser(@PathVariable String nikUser) {
        return userService.getUserByNik(nikUser);
    }

    @GetMapping("/person/{id}")
    public UserModel getUserByUserId (@PathVariable int id){
        return userService.getUserById(id).get();
    }
    @GetMapping("/login")
    public GetUserModel login(@RequestParam String nikUser, @RequestParam String password) {
        GetUserModel getUserModel = new GetUserModel();
        UserModels userModel = new UserModels();

        if(userService.login(nikUser, password)) {
            getUserModel.setStatus("success");
            getUserModel.setUserModel(getUserByNikUser(nikUser));
            getUserModel.setUserId(userModel.getUserId());
            return getUserModel;
        } else {
            getUserModel.setStatus("failed");
            return getUserModel;
        }
    }

//    @DeleteMapping("/person/delete/{id}")
//    public Map<String, Boolean> deleteUser(
//            @PathVariable(value = "id") int id) throws Exception {
//    }
}
