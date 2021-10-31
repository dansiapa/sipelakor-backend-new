package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.FormLaporanModel;
import com.poldasulut.sipelakor.model.nofk.FormLaporan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormLaporanRepositories extends JpaRepository<FormLaporan,Integer> {

    FormLaporan getFormLaporanModelNewByTanggalKejadian(String tanggalKejadian);

    List<FormLaporan> findAllByUserId(int userId);

    @Query(value = "SELECT * FROM form_laporan l WHERE l.id_user = :userId",
            nativeQuery = true)
    List<FormLaporan> getAllByFkUserIdUserId(int userId);
    

}
