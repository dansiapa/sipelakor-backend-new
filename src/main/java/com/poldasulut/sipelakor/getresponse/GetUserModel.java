package com.poldasulut.sipelakor.getresponse;

import com.poldasulut.sipelakor.model.UserModel;
import com.poldasulut.sipelakor.model.nofk.UserModels;

public class GetUserModel {
    private String status;
    private UserModels userModel;
    private int userId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserModels getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModels userModel) {
        this.userModel = userModel;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
