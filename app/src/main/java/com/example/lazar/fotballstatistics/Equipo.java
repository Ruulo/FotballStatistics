package com.example.lazar.fotballstatistics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.BufferedReader;

public class Equipo {
    String nombre;
    Bitmap escudo;

    public Equipo(String n, String bm){
        nombre = n;
        String cleanB64 = bm.split(",")[1];

        byte[] decodedString = cleanB64.getBytes();

        escudo = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
