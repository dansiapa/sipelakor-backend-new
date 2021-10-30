package com.poldasulut.sipelakor.getresponse;

import com.poldasulut.sipelakor.model.nofk.FormLaporan;

public class GetFormResponse {
    private String status;
    private FormLaporan formLaporan;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FormLaporan getFormLaporan() {
        return formLaporan;
    }

    public void setFormLaporan(FormLaporan formLaporan) {
        this.formLaporan = formLaporan;
    }
}
