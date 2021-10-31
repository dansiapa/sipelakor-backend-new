package com.poldasulut.sipelakor.getresponse;

import com.poldasulut.sipelakor.model.FormLaporanModel;
import com.poldasulut.sipelakor.model.nofk.FormLaporan;

public class GetFormResponse {
    private String status;
    private FormLaporanModel formLaporan;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FormLaporanModel getFormLaporan() {
        return formLaporan;
    }

    public void setFormLaporan(FormLaporanModel formLaporan) {
        this.formLaporan = formLaporan;
    }
}
