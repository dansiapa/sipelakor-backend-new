package com.poldasulut.sipelakor.repository;

import com.poldasulut.sipelakor.model.nofk.FormLaporan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormLaporanRepositories extends JpaRepository<FormLaporan,Integer> {

    FormLaporan getFormLaporanModelNewByTanggalKejadian(String tanggalKejadian);
}
