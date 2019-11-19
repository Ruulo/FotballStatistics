package com.example.lazar.fotballstatistics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedReader;

public class Equipo {
    String nombre;
    Bitmap escudo;

    public Equipo(String n, String bm){
        nombre = n;
        String cleanB64 = bm.split(",")[1];

        Log.d("TEST", cleanB64);
        Log.d("TEST", n);

        byte[] decodedString = Base64.decode(cleanB64, Base64.DEFAULT);

        escudo = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
