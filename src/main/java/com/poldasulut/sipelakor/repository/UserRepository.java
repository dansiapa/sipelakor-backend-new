package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.nofk.UserModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModels,Integer> {

    UserModels findAllByNikUser(String nik);
}
