package com.poldasulut.sipelakor.utils;

import org.springframework.stereotype.Service;

@Service
public class FileUtils {
    public String getExtension(String filename) {
        String extension = "";
        String[] arr = filename.split("\\.");
        if(arr.length > 0) {
            extension = arr[arr.length - 1];
            return "."+extension;
        }else {
            return extension;
        }
    }
}
