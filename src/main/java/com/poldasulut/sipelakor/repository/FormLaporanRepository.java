package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.FormLaporanModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormLaporanRepository extends JpaRepository<FormLaporanModel,Integer> {

    List<FormLaporanModel> findAllByUserId(int userId);
}
