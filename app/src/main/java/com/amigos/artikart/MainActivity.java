package com.amigos.artikart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private DatabaseReference mdbr;
    private Button b1;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=(Button)findViewById(R.id.button);
        mdbr=FirebaseDatabase.getInstance().getReference();
        tv=(TextView)findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mdbr.child("Artisans").child("9050838857").setValue(new Artisan("Jaydeep","9052838857","3928329382938"));
                //mdbr.child("ArtisanNos").setValue(new ArrayList<String>().add("9052838857"));

                /*DatabaseFunctions df=new DatabaseFunctions();
                if(df.customerExists("9052838857")){
                    tv.setText("Yes");
                }
                else{
                    tv.setText("No");
                }*/

                /*mdbr.child("Artisans").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("9052838887")){
                            tv.setText("Yes");

                        }
                        else{
                            tv.setText("No");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });*/

            }
        });

    }
    public void uploadImg(View v){
        Intent i=new Intent(this,CameraUpload.class);
        startActivity(i);
    }
}
