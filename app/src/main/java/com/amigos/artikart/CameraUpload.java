package com.amigos.artikart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;



public class CameraUpload extends AppCompatActivity {

    private Button mUploadBtn;
    private ImageView mImageView;

    private static final int CAMERA_EQUEST_CODE=1;

    private StorageReference mStorage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_upload);




        mUploadBtn=(Button)findViewById(R.id.uploadBtn);
        mImageView=(ImageView)findViewById(R.id.imageView);



    }

    public void uploadClick(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAMERA_EQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)throws NullPointerException {
        super.onActivityResult(requestCode, resultCode, data);
        /*
        if (requestCode == CAMERA_EQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
            //uploadImage(imageBitmap);
            filepath=data.getData();
            uploadimg();
            DatabaseReference mdbr;
            mdbr=FirebaseDatabase.getInstance().getReference();
            mdbr.child("Images").setValue(imageBitmap.toString());
        }
         */
        if(requestCode==CAMERA_EQUEST_CODE && resultCode==RESULT_OK){
            mStorage=FirebaseStorage.getInstance().getReference();

            Uri uri=data.getData();


            StorageReference filePath=mStorage.child("Photo").child(uri.getLastPathSegment());

            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(CameraUpload.this, "Uploading Finished", Toast.LENGTH_SHORT).show();
                }
            });

        }
        else {
            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
        }
    }
}
