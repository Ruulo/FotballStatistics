package com.example.lazar.fotballstatistics;

import android.app.Activity;
import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void Ranking(View v){
        Intent i = new Intent(getApplicationContext(), Ranking.class);
        startActivity(i);
    }


    public void Partidos(View v){
        Intent i = new Intent(getApplicationContext(), Partidos.class);
        startActivity(i);
    }
}
