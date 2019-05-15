package com.amigos.artikart;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseFunctions {
    private DatabaseReference mDatabase;
    public void registerArtisian(String uname,String phno,String bankno){
        mDatabase=FirebaseDatabase.getInstance().getReference().child("AtrisanList");
        mDatabase.child(phno).setValue(new Artisan(uname,phno,bankno));
    }

    public void registerCustomer(String uname,String phno,String mainAddress,String  city,String ustate,String pin){
        mDatabase=FirebaseDatabase.getInstance().getReference().child("CustomerList");
        mDatabase.child(phno).setValue(new Customer(uname,phno,mainAddress,city,ustate,pin));
    }
    public void verifyPhNo(String phno){
        String phoneNumber, otp;


    }

}
