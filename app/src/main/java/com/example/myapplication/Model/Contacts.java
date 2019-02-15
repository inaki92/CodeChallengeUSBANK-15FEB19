package com.example.myapplication.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Contacts {


    @SerializedName("contacts")
    @Expose
    private List<Information> contacts = null;

    public List<Information> getContacts() {
        return contacts;
    }

    public void setContacts(List<Information> contacts) {
        this.contacts = contacts;
    }
}
