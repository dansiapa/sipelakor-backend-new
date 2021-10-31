package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.FormLaporanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FormLaporanRepository extends JpaRepository<FormLaporanModel,Integer> {

    @Query(value = "SELECT * FROM form_laporan l INNER JOIN user u WHERE l.id_user = u.id_user AND l.id_user = :userId",
    nativeQuery = true)
    List<FormLaporanModel> getAllByFkUserIdUserId(int userId);

    List<FormLaporanModel> findAllByFkUserId(int userId);

    List<FormLaporanModel> findAllByFkUserIdUserId(int userId);
}
