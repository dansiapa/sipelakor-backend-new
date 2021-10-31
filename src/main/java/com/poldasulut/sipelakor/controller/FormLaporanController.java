package com.poldasulut.sipelakor.controller;

import com.poldasulut.sipelakor.getresponse.GetFormResponse;
import com.poldasulut.sipelakor.model.FormLaporanModel;
import com.poldasulut.sipelakor.model.UserModel;
import com.poldasulut.sipelakor.model.nofk.FormLaporan;
import com.poldasulut.sipelakor.service.FormLaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class FormLaporanController {

    @Autowired
    private FormLaporanService formLaporanService;

    @PostMapping("/create_laporan")
    public GetFormResponse createLaporan(@RequestParam int user, @RequestParam String tanggalKejadian,
                                         @RequestParam String lokasi, @RequestParam String dokument1, @RequestParam String dokument2,
                                         @RequestParam String dokument3, @RequestParam String ktp,
                                         @RequestParam String kta, @RequestParam String detail, @RequestParam String statusLaporan,
                                         @RequestParam String statusPelapor) {
        GetFormResponse getFormResponse = new GetFormResponse();
        FormLaporan formLaporanModelNew = formLaporanService.createFormInvitation(user,
                tanggalKejadian, lokasi, dokument1, dokument2, dokument3, ktp,
                kta, detail, statusLaporan, statusPelapor);
        if (Objects.nonNull(formLaporanModelNew)) {
            getFormResponse.setStatus("success");
            getFormResponse.setFormLaporan(formLaporanModelNew);
            return getFormResponse;
        }else {
            getFormResponse.setStatus("failed");
            return getFormResponse;
        }
    }

    @GetMapping("/laporan/user={userId}")
    public List<FormLaporanModel> getLaporan(@PathVariable int userId){
        return formLaporanService.getByUserId(userId);
    }

    @GetMapping("/laporan={id}")
    public Optional<FormLaporanModel> getLaporanById(@PathVariable int id){
        return formLaporanService.getByLaporanId(id);
    }


//    @DeleteMapping("/rundownevent/delete/{laporanId}")
//    public String deleteFormLaporan(@PathVariable int laporanId) {
//        if(formLaporanService.deleteFormLaporan(laporanId)) {
//            return "Success delete Laporan with id "+laporanId;
//        }else {
//            return "Laporan with id "+laporanId+" not found";
//        }
//    }

    @PostMapping("/upload")
    public boolean singleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam int laporanId) {
        return formLaporanService.saveFile(file,laporanId);
    }
}
