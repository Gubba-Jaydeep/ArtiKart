package com.amigos.artikart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterDetails extends AppCompatActivity {
    EditText customerName,customerState,customerCity,customerPinCode,customerExtraAddress;
    String cPhone;
    private DatabaseFunctions df;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_details);
        Intent intent = getIntent();
        cPhone = intent.getStringExtra("customerPhoneExtra");

        customerName = (EditText)findViewById(R.id.customerName);
        customerState = (EditText)findViewById(R.id.customerState);
        customerCity = (EditText)findViewById(R.id.customerCity);
        customerPinCode = (EditText)findViewById(R.id.customerPinCode);
        customerExtraAddress =(EditText)findViewById(R.id.extraAddress);
        df=new DatabaseFunctions();
    }

    public void registerCustomer(View view)
    {
        Toast.makeText(getApplicationContext(),"Registration Done",Toast.LENGTH_LONG);
        df.registerCustomer(customerName.getText().toString(),cPhone,customerExtraAddress.getText().toString(),customerCity.getText().toString(),customerState.getText().toString(), customerPinCode.getText().toString());
        Intent i = new Intent(getApplicationContext(),CustomerHomePage.class);
        startActivity(i);
    }


}
