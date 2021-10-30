package com.poldasulut.sipelakor.model.nofk;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "form_laporan")
public class FormLaporan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laporan")
    private int laporanId;
    @Column(name = "id_user")
    private int userId;
    @Column(name = "tanggal_kejadian")
    private String tanggalKejadian;
    @Column(name = "lokasi_kejadian")
    private String lokasiKejadian;
    @Column(name = "dokumen_pendukung1")
    private String dokumentPendukung1;
    @Column(name = "dokumen_pendukung2")
    private String dokumentPendukung2;
    @Column(name = "dokumen_pendukung3")
    private String dokumentPendukung3;
    @Column(name = "status_pekerjaan")
    private String statusPelapor;
    @Column(name = "ktp_pelapor")
    private String ktpPelapor;
    @Column(name = "kta_pelapor")
    private String ktaPelapor;
    @Column(name = "detail_kejadian")
    private String detailKejadian;
    @Column(name = "status_laporan")
    private String statusLaporan;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public int getLaporanId() {
        return laporanId;
    }

    public void setLaporanId(int laporanId) {
        this.laporanId = laporanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTanggalKejadian() {
        return tanggalKejadian;
    }

    public void setTanggalKejadian(String tanggalKejadian) {
        this.tanggalKejadian = tanggalKejadian;
    }

    public String getLokasiKejadian() {
        return lokasiKejadian;
    }

    public void setLokasiKejadian(String lokasiKejadian) {
        this.lokasiKejadian = lokasiKejadian;
    }

    public String getDokumentPendukung1() {
        return dokumentPendukung1;
    }

    public void setDokumentPendukung1(String dokumentPendukung1) {
        this.dokumentPendukung1 = dokumentPendukung1;
    }

    public String getDokumentPendukung2() {
        return dokumentPendukung2;
    }

    public void setDokumentPendukung2(String dokumentPendukung2) {
        this.dokumentPendukung2 = dokumentPendukung2;
    }

    public String getDokumentPendukung3() {
        return dokumentPendukung3;
    }

    public void setDokumentPendukung3(String dokumentPendukung3) {
        this.dokumentPendukung3 = dokumentPendukung3;
    }

    public String getStatusPelapor() {
        return statusPelapor;
    }

    public void setStatusPelapor(String statusPelapor) {
        this.statusPelapor = statusPelapor;
    }

    public String getKtpPelapor() {
        return ktpPelapor;
    }

    public void setKtpPelapor(String ktpPelapor) {
        this.ktpPelapor = ktpPelapor;
    }

    public String getKtaPelapor() {
        return ktaPelapor;
    }

    public void setKtaPelapor(String ktaPelapor) {
        this.ktaPelapor = ktaPelapor;
    }

    public String getDetailKejadian() {
        return detailKejadian;
    }

    public void setDetailKejadian(String detailKejadian) {
        this.detailKejadian = detailKejadian;
    }

    public String getStatusLaporan() {
        return statusLaporan;
    }

    public void setStatusLaporan(String statusLaporan) {
        this.statusLaporan = statusLaporan;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
