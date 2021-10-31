package com.poldasulut.sipelakor.controller;

import com.poldasulut.sipelakor.getresponse.GetLoginResponse;
import com.poldasulut.sipelakor.getresponse.GetUserModel;
import com.poldasulut.sipelakor.model.KotaKabupatenModel;
import com.poldasulut.sipelakor.model.UserModel;
import com.poldasulut.sipelakor.model.nofk.UserModels;
import com.poldasulut.sipelakor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public GetLoginResponse createPerson(@RequestParam KotaKabupatenModel kotaKabupaten, @RequestParam  String nik, @RequestParam  String username,
                                         @RequestParam String jobs, @RequestParam  String address, @RequestParam String nomor, @RequestParam  String email, @RequestParam  String password,
                                         @RequestParam int status, @RequestParam String tanggalLahir) {
        GetLoginResponse getUserModel = new GetLoginResponse();
        UserModel userModel = userService.createUser(kotaKabupaten, nik, username,jobs, address, nomor, email, password,status,
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
    public UserModel getUserByNikUser(@PathVariable String nikUser) {
        return userService.getUserByNik(nikUser);
    }

    @GetMapping("/person={userId}")
    public Optional<UserModel> getUserByUserId (@PathVariable int userId){
        return userService.getUserById(userId);
    }
    @GetMapping("/login")
    public GetLoginResponse login(@RequestParam String nikUser, @RequestParam String password) {
        GetLoginResponse getLoginResponse = new GetLoginResponse();
        UserModel userModel = new UserModel();

        if(userService.login(nikUser, password)) {
            getLoginResponse.setStatus("success");
            getLoginResponse.setUserModel(getUserByNikUser(nikUser));
            getLoginResponse.setUserId(userModel.getUserId());
            return getLoginResponse;
        } else {
            getLoginResponse.setStatus("failed");
            return getLoginResponse;
        }
    }

//    @DeleteMapping("/person/delete/{id}")
//    public Map<String, Boolean> deleteUser(
//            @PathVariable(value = "id") int id) throws Exception {
//        UserModel user = userService.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: "+ userId));
//
//        userService.delete(user);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
}
