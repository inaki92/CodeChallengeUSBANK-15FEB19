package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Model.Contacts;
import com.example.myapplication.R;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    private Context mCtx;
    private Contacts contList;

    public ContactsAdapter(Context mCtx,Contacts contList){
        this.contList = contList;
        this.mCtx = mCtx;
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder{

        TextView name, email, add, phone;

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_name);
            email = itemView.findViewById(R.id.tv_email);
            add = itemView.findViewById(R.id.tv_add);
            phone = itemView.findViewById(R.id.tv_phone);
        }
    }


    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.recycler_card,viewGroup,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder contactsViewholder, int i) {

        contactsViewholder.name.setText(contList.getContacts().get(i).getName());
        contactsViewholder.add.setText(contList.getContacts().get(i).getAddress());
        contactsViewholder.email.setText(contList.getContacts().get(i).getEmail());
        contactsViewholder.phone.setText(contList.getContacts().get(i).getPhone().getMobile());

    }

    @Override
    public int getItemCount() {
        return contList.getContacts().size();
    }
}
