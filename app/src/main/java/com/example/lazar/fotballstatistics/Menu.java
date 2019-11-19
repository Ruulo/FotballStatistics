package com.example.lazar.fotballstatistics;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class Menu extends Activity {
    public static String[] partidos = new String[0];
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);




    }

    @Override
    protected void onResume() {
        super.onResume();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://cascaritaapp.000webhostapp.com/webservice/getpartidos.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String st = new String(responseBody);
                Log.d("TEST", st);
                Menu.partidos = st.split(",");
                loadAll();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void addPartido(Partido p){
        LinearLayout ll = (LinearLayout)findViewById(R.id.listView);



        View c = getLayoutInflater().inflate(R.layout.partido, null);
        TextView tvA = (TextView) c.findViewById(R.id.eAn);
        TextView tvB = (TextView) c.findViewById(R.id.eBn);
        ImageView ivA = (ImageView) c.findViewById(R.id.eA);
        ImageView ivB = (ImageView) c.findViewById(R.id.eB);
        TextView goles = (TextView) c.findViewById(R.id.puntuacion);
        tvA.setText(db.equipos.get(p.idEquipoA).nombre);
        tvB.setText(db.equipos.get(p.idEquipoB).nombre);
        ivA.setImageBitmap(db.equipos.get(p.idEquipoA).escudo);
        ivB.setImageBitmap(db.equipos.get(p.idEquipoB).escudo);
        goles.setText(p.golesA + "-" + p.golesB);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ll.addView(c);
    }

    public void loadAll(){
        LinearLayout ll = (LinearLayout)findViewById(R.id.listView);
        ll.removeAllViews();
        for (String s: partidos) {
            if(s != ""){
                Log.d("TEST", s);
                new loaderPartido(Integer.parseInt(s), this);
            }
        }
    }



}
