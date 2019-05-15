package com.amigos.artikart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.TimerTask;

public class CustomerHomePage extends AppCompatActivity {


    ImageView slideShowimage;
    int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
    Button shop,myFavs,myDetails,myOrders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home_page);

        slideShowimage = (ImageView)findViewById(R.id.slideShowImage);
        shop = (Button) findViewById(R.id.shop);
        myFavs = (Button) findViewById(R.id.myFavsButton);
        myDetails = (Button) findViewById(R.id.myDetailsButton);
        myOrders = (Button) findViewById(R.id.myOrdersButton);

    }

    public void shopClick(View view)
    {
        Intent i =new Intent(getApplicationContext(),ShoppingPage.class);
        startActivity(i);
    }

    public void myFavsClick(View view)
    {
        Intent i =new Intent(getApplicationContext(),MyFavsPage.class);
        startActivity(i);
    }

    public void myDetailsClick(View view)
    {
        Intent i =new Intent(getApplicationContext(),MyDetailsPage.class);
        startActivity(i);
    }

    public void myOrdersClick(View view)
    {
        Intent i =new Intent(getApplicationContext(),MyFavsPage.class);
        startActivity(i);
    }




}
