package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepositories extends JpaRepository<UserModel,Integer> {
    List<UserModel> findAllByUserEmail(String userEmail);

    UserModel findAllByNikUser(String nikUser);
}
