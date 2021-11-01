package com.poldasulut.sipelakor.controller;

import com.poldasulut.sipelakor.getresponse.GetFormResponse;
import com.poldasulut.sipelakor.getresponse.ResponseMessage;
import com.poldasulut.sipelakor.model.FileInfo;
import com.poldasulut.sipelakor.model.FormLaporanModel;
import com.poldasulut.sipelakor.model.nofk.FormLaporan;
import com.poldasulut.sipelakor.repository.FileStorageService;
import com.poldasulut.sipelakor.service.FormLaporanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class FormLaporanController {

    @Autowired
    private FormLaporanService formLaporanService;

    @Autowired
    private FileStorageService storageService;

//    @Autowired
//    IFileSytemStorage fileSytemStorage;

    @PostMapping("/createlaporan")
    public GetFormResponse createLaporan(@RequestParam int user, @RequestParam String tanggalKejadian,
                                         @RequestParam String lokasi, @RequestParam String dokument1,
                                         @RequestParam String dokument2, @RequestParam String dokument3,
                                         @RequestParam String statusPelapor, @RequestParam String ktp,
                                         @RequestParam String kta, @RequestParam String detail,
                                         @RequestParam String statusLaporan
                                         ) {
        GetFormResponse getFormResponse = new GetFormResponse();
        FormLaporan formLaporanModelNew = formLaporanService.createFormInvitation(user,
                tanggalKejadian, lokasi, dokument1, dokument2, dokument3,statusPelapor, ktp,
                kta, detail, statusLaporan);
        if (Objects.nonNull(formLaporanModelNew)) {
            getFormResponse.setStatus("success");
            getFormResponse.setFormLaporan(formLaporanModelNew);
            return getFormResponse;
        }else {
            getFormResponse.setStatus("failed");
            return getFormResponse;
        }
    }

    @GetMapping("/laporan/user/{userId}")
    public List<FormLaporanModel> getLaporan(@PathVariable int userId){
        return formLaporanService.getFormLaporanByUserId(userId);
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


//    @PostMapping("/upload")
//    public boolean singleFileUpload(@RequestParam("file") MultipartFile file,
//                                   @RequestParam int laporanId) {
//        return formLaporanService.saveFile(file,laporanId);
//    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFiles(@RequestParam("files") MultipartFile[] files) {
        String message = "";
        try {
            List<String> fileNames = new ArrayList<>();

            Arrays.asList(files).stream().forEach(file -> {
                storageService.save(file);
                fileNames.add(file.getOriginalFilename());
            });

            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Fail to upload files!!"+e.toString();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message+e.toString()));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getListFiles() {
        List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FormLaporanController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


//    //SINGLE
//    @PostMapping("/uploadfile")
//    public ResponseEntity<FileResponse> uploadSingleFile (@RequestParam("file") MultipartFile file) {
//        String upfile = fileSytemStorage.saveFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/api/download/")
//                .path(upfile)
//                .toUriString();
//
//        return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(upfile,fileDownloadUri,"File uploaded with success!"));
//    }
//
//    //MULTIPLE
//    @PostMapping("/uploadfiles")
//    public ResponseEntity<List<FileResponse>> uploadMultipleFiles (@RequestParam("files") MultipartFile[] files) {
//
//        List<FileResponse> responses = Arrays
//                .asList(files)
//                .stream()
//                .map(
//                        file -> {
//                            String upfile = fileSytemStorage.saveFile(file);
//                            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                                    .path("/api/download/")
//                                    .path(upfile)
//                                    .toUriString();
//                            return new FileResponse(upfile,fileDownloadUri,"File uploaded with success!");
//                        }
//                )
//                .collect(Collectors.toList());
//        return ResponseEntity.status(HttpStatus.OK).body(responses);
//    }
}
