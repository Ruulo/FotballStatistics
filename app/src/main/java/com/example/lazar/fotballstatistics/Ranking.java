package com.example.lazar.fotballstatistics;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class Ranking extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://cascaritaapp.000webhostapp.com/webservice/getranking.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String st = new String(responseBody);
                String[] equipos = st.split(":");
                addEquipos(equipos);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }


    public void addEquipos(String[] datos){
        LinearLayout ll = (LinearLayout)findViewById(R.id.llEquipos);
        ll.removeAllViews();
        int r = 1;
        for (String s: datos) {
            String[] map = s.split(",");

            View v = getLayoutInflater().inflate(R.layout.equipo, null);
            ll.addView(v);
            db.loadEquipoRank(Integer.parseInt(map[0]), v, Integer.parseInt(map[1]), r);
            r++;
        }
    }


    public static void addEquipo(Equipo e, int r, int g, View v){

        TextView rank = (TextView)v.findViewById(R.id.posicion);
        ImageView escudo = (ImageView)v.findViewById(R.id.imagen);
        TextView nombre = (TextView)v.findViewById(R.id.nombre);
        TextView goles = (TextView)v.findViewById(R.id.goles);

        rank.setText(String.valueOf(r));
        escudo.setImageBitmap(e.escudo);
        nombre.setText(e.nombre);
        goles.setText(String.valueOf(g));

    }
}
