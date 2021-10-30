package com.poldasulut.sipelakor.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int userId;
    @ManyToOne
    @JoinColumn(name = "id_kota_kab")
    private KotaKabupatenModel fkKotaKabId;
    @Column(name = "nik_user")
    private String nikUser;
    @Column(name = "name_user")
    private String userName;
    @Column(name = "jobs")
    private String jobs;
    @Column(name = "address_user")
    private String addressUser;
    @Column(name = "nomor_user")
    private String nomorUser;
    @Column(name = "email_user")
    private String userEmail;
    @Column(name = "password_user")
    private String userPassword;
    @Column(name = "status_user")
    private int userStatus;
    @Column(name = "user_ttl")
    private String tanggalLahir;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public KotaKabupatenModel getFkKotaKabId() {
        return fkKotaKabId;
    }

    public void setFkKotaKabId(KotaKabupatenModel fkKotaKabId) {
        this.fkKotaKabId = fkKotaKabId;
    }

    public String getNikUser() {
        return nikUser;
    }

    public void setNikUser(String nikUser) {
        this.nikUser = nikUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getNomorUser() {
        return nomorUser;
    }

    public void setNomorUser(String nomorUser) {
        this.nomorUser = nomorUser;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
}
