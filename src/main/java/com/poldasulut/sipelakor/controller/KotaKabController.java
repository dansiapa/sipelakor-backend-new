package com.poldasulut.sipelakor.controller;

import com.poldasulut.sipelakor.model.KotaKabupatenModel;
import com.poldasulut.sipelakor.service.KotaKabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KotaKabController {

    @Autowired
    private KotaKabService kotaKabService;

    @GetMapping
    public Iterable<KotaKabupatenModel> getAllKotaKab(){
        return kotaKabService.getAllKotaKab();
    }
}
