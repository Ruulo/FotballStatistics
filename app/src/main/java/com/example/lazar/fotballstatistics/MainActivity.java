package com.example.lazar.fotballstatistics;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static Partido partido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView eqA = (TextView) findViewById(R.id.equipoA);
        TextView eqB = (TextView) findViewById(R.id.equipoB);
        TextView goA = (TextView) findViewById(R.id.equipoAGoles);
        TextView goB = (TextView) findViewById(R.id.equipoBGoles);
        ImageView eqAI = (ImageView) findViewById(R.id.equipoAImg);
        ImageView eqBI = (ImageView) findViewById(R.id.equipoBImg);

        eqA.setText(db.equipos.get(partido.idEquipoA).nombre);
        eqB.setText(db.equipos.get(partido.idEquipoB).nombre);

        goA.setText(String.valueOf(partido.golesA));
        goB.setText(String.valueOf(partido.golesB));

        eqAI.setImageBitmap(db.equipos.get(partido.idEquipoA).escudo);
        eqBI.setImageBitmap(db.equipos.get(partido.idEquipoB).escudo);

    }

}
