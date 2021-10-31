package com.poldasulut.sipelakor.service;

import com.poldasulut.sipelakor.model.UserModel;
import com.poldasulut.sipelakor.model.nofk.UserModels;
import com.poldasulut.sipelakor.repository.UserRepositories;
import com.poldasulut.sipelakor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private UserRepositories userRepositories;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepositories userRepositories, UserRepository userRepository){
        this.userRepositories = userRepositories;
        this.userRepository = userRepository;
    }

    public UserModels createUser(int kotaKabupaten, String nik, String username, String jobs, String address,
                                 String nomor, String email, String password, int status,
                                 String tanggalLahir) {
        UserModels userModelNew = new UserModels();

        if(Objects.nonNull(userRepository.findAllByNikUser(nik))) {
            return null;
        }else {
            userModelNew.setKotaKabupatenId(kotaKabupaten);
            userModelNew.setNikUser(nik);
            userModelNew.setUserName(username);
            userModelNew.setJobs(jobs);
            userModelNew.setAddressUser(address);
            userModelNew.setNomorUser(nomor);
            userModelNew.setUserEmail(email);
            userModelNew.setUserPassword(password);
            userModelNew.setUserStatus(status);
            userModelNew.setTanggalLahir(tanggalLahir);
        }
        return userRepository.save(userModelNew);
    }


    public Optional<UserModel> getUser(int id) {
        return userRepositories.findById(id);
    }

    public Iterable<UserModel> getAllUser() {
        return userRepositories.findAll();
    }

    public List<UserModel> getEmail(String userEmail){
        return userRepositories.findAllByUserEmail(userEmail);
    }

    public UserModels getUserByNik(String nikUser) {
        return userRepository.findAllByNikUser(nikUser);
    }
    public boolean login(String nikUser, String password) {
        UserModel userModel = userRepositories.findAllByNikUser(nikUser);
        if(Objects.nonNull(userModel)) {
            if(userModel.getUserPassword().equals(password)) {
                return true;
            }else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ResponseEntity<UserModels> updateData (int id, UserModels userModel){
        Optional<UserModels> userModelUpdate = userRepository.findById(id);
        if(userModelUpdate.isPresent()) {
            UserModels uModel = userModelUpdate.get();
            uModel.setKotaKabupatenId(userModel.getKotaKabupatenId());
            uModel.setNikUser(userModel.getNikUser());
            uModel.setUserName(userModel.getUserName());
            uModel.setJobs(userModel.getJobs());
            uModel.setAddressUser(userModel.getAddressUser());
            uModel.setNomorUser(userModel.getNomorUser());
            uModel.setUserEmail(userModel.getUserEmail());
            uModel.setUserPassword(userModel.getUserPassword());
            uModel.setUserStatus(userModel.getUserStatus());
            uModel.setTanggalLahir(userModel.getTanggalLahir());
            return new ResponseEntity<>(userRepository.save(uModel), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    public Optional<UserModel> getUserById(int id) {
        return userRepositories.findById(id);
    }

    public boolean deleteUser(int userId) {
        Optional<UserModel> userModel = Optional.empty();
        if(userModel.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }else {
            return false;
        }
    }

    public Optional<UserModel> findById(int id) {
        return userRepositories.findById(id);
    }

}
