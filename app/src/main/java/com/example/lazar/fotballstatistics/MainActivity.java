package com.example.lazar.fotballstatistics;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements FragmentBlue.OnFragmentInteractionListener, FragmentGreen.OnFragmentInteractionListener,
        FragmentRed.OnFragmentInteractionListener{
    FragmentBlue fragmentBlue;
    FragmentGreen fragmentGreen;
    FragmentRed fragmentRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentBlue=new FragmentBlue();
        fragmentGreen=new FragmentGreen();
        fragmentRed=new FragmentRed();
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorFragments,fragmentBlue).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.btn1:
                transaction.replace(R.id.ContenedorFragments,fragmentRed);
                break;
            case R.id.btn2:
                transaction.replace(R.id.ContenedorFragments,fragmentBlue);
                break;
            case R.id.btn3:
                transaction.replace(R.id.ContenedorFragments,fragmentGreen);
                break;

        }
        transaction.commit();

    }
}
