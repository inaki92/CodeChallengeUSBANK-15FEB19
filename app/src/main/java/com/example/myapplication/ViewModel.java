package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.myapplication.Model.Contacts;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModel extends android.arch.lifecycle.ViewModel {
    private static final String TAG = "ViewModel";

    private MutableLiveData<Contacts> contactList;

    public LiveData<Contacts> getContacts(){

        if (contactList == null){
            contactList = new MutableLiveData<Contacts>();
            loadContacts();
        }
        return contactList;
    }

    private void loadContacts(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(api_request.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        API_connection api = retrofit.create(API_connection.class);
        Call<Contacts> call = api.getContacts();

        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                contactList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());

            }
        });
    }
}
