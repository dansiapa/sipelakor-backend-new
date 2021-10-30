package com.poldasulut.sipelakor.model;

import javax.persistence.*;

@Entity
@Table(name = "kota_kabupaten")
public class KotaKabupatenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kota_kab")
    private int kotaKabId;
    @Column(name = "kota_kab")
    private String kotaKab;

    public int getKotaKabId() {
        return kotaKabId;
    }

    public void setKotaKabId(int kotaKabId) {
        this.kotaKabId = kotaKabId;
    }

    public String getKotaKab() {
        return kotaKab;
    }

    public void setKotaKab(String kotaKab) {
        this.kotaKab = kotaKab;
    }
}
