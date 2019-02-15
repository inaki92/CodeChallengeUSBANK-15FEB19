package com.example.myapplication;

import com.example.myapplication.Model.Contacts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_connection {

    @GET(api_request.CONTACTS_URL)
    Call<Contacts> getContacts();
}
