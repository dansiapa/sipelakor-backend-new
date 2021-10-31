package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.nofk.FormLaporan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormLaporanRepositories extends JpaRepository<FormLaporan,Integer> {

    FormLaporan getFormLaporanModelNewByTanggalKejadian(String tanggalKejadian);

    List<FormLaporan> findAllByUserId(int userId);
}
