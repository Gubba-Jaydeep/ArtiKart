package com.amigos.artikart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RegisterActivity extends AppCompatActivity {

    EditText customerNumber;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        customerNumber = findViewById(R.id.customerPhoneText);
        //Database Init
        mDatabase=FirebaseDatabase.getInstance().getReference();
        StorageReference dref=FirebaseStorage.getInstance().getReference();
    }

    public void customerRegister(View view)
    {
        final String customerPhone = customerNumber.getText().toString();
        mDatabase.child("CustomerList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(customerPhone)){
                    //Yes
                    Toast.makeText(RegisterActivity.this, "Customer Exists", Toast.LENGTH_SHORT).show();
                    //Otp => homePage


                }
                else{
                    //No

                    Toast.makeText(RegisterActivity.this, "No Customer", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),RegisterDetails.class);
                    i.putExtra("customerPhoneExtra",customerPhone);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}

