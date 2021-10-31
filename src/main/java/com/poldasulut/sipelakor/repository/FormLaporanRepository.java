package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.FormLaporanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FormLaporanRepository extends JpaRepository<FormLaporanModel,Integer> {

    List<FormLaporanModel> findAllByFkUserIdUserId(int userId);

    List<FormLaporanModel> findAllByFkUserId(int userId);
}
