package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Adapter.ContactsAdapter;
import com.example.myapplication.Model.Contacts;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecycler;
    Contacts contacts_List;
    ContactsAdapter mAdapter;

    TextView example;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example = findViewById(R.id.tv_ex);
        searchView = findViewById(R.id.search_item);
        //searchView.getQuery().toString();

        mRecycler = findViewById(R.id.my_recycler);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        loadcontacts();

        example.setText(searchView.getQuery().toString());

    }


    private void loadcontacts(){
        ViewModel model = ViewModelProviders.of(this).get(ViewModel.class);

        model.getContacts().observe(this, new Observer<Contacts>() {
            @Override
            public void onChanged(@Nullable Contacts contactsList) {

                contacts_List = contactsList;
                mAdapter = new ContactsAdapter(getBaseContext(),contactsList);
                mRecycler.setAdapter(mAdapter);
            }
        });
    }
}
