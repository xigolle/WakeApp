package com.example.joeyd.wakeapp;

import android.graphics.Bitmap;

/**
 * Created by joeyd on 7-1-2016.
 */
public class ContactUser {
    String name;

    public Bitmap getThumb() {
        return thumb;
    }

    public void setThumb(Bitmap thumb) {
        this.thumb = thumb;
    }

    Bitmap thumb;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    String phone;

    public Boolean getCheckedBox() {
        return checkedBox;
    }

    public void setCheckedBox(Boolean checkedBox) {
        this.checkedBox = checkedBox;
    }

    Boolean checkedBox = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
