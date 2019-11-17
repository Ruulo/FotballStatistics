package com.example.lazar.fotballstatistics;

import android.graphics.Bitmap;

public class Partido {

    int idPartido;

    int idEquipoA;
    int idEquipoB;

    String equipo1;
    String equipo2;

    int arbitro;
    String ubicacion;

    public Partido(String idP, String eqA, String eqB, String arb, String ubi){
        idPartido = Integer.parseInt(idP);
        idEquipoA = Integer.parseInt(eqA);
        idEquipoB = Integer.parseInt(eqB);
        arbitro = Integer.parseInt(arb);
        ubicacion = ubi;
        if(db.equipos.get(idEquipoA) == null){
            db.equipos.put(idEquipoA, db.getEquipo(idEquipoA));
        }
        if(db.equipos.get(idEquipoB) == null){
            db.equipos.put(idEquipoB, db.getEquipo(idEquipoB));
        }
    }
}
