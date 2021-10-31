package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepositories extends JpaRepository<UserModel,Integer> {
    List<UserModel> findAllByUserEmail(String userEmail);

    UserModel findAllByNikUser(String nikUser);

    @Query(value = "SELECT * FROM user u WHERE u.id_user = :userId", nativeQuery = true)
    Optional<UserModel> getByUserId(int userId);
}
