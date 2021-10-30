package com.poldasulut.sipelakor.service;

import com.poldasulut.sipelakor.model.KotaKabupatenModel;
import com.poldasulut.sipelakor.repository.KotaKabRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KotaKabService {
    private KotaKabRepositories kotaKabRepositories;

    @Autowired
    public KotaKabService (KotaKabRepositories kotaKabRepositories){
        this.kotaKabRepositories =kotaKabRepositories;
    }

    public Iterable<KotaKabupatenModel> getAllKotaKab() {
        return kotaKabRepositories.findAll();
    }
}
