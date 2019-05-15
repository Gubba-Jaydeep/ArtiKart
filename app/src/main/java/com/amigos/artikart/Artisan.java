package com.amigos.artikart;

import java.util.ArrayList;

public class Artisan {
    String uname;
    String phno;
    String bank;
    ArrayList<String> photos;

    Artisan(String uname,String phno,String bankno){

        this.uname=uname;
        this.bank=bankno;
        this.phno=phno;
        photos=new ArrayList<>();

    }
}
