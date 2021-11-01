package com.poldasulut.sipelakor.model;

public class FileInfo {
    private String name;
    private String url;

    public FileInfo(String filename, String url) {
        this.name = filename;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
