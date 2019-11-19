package com.example.lazar.fotballstatistics;

public class Partido {

    int idPartido;

    int idEquipoA;
    int idEquipoB;

    int arbitro;
    String ubicacion;

    int golesA;
    int golesB;

    public Partido(String idP, String eqA, String eqB, String arb, String ubi, String ga, String gb){

        idPartido = Integer.parseInt(idP);
        idEquipoA = Integer.parseInt(eqA);
        idEquipoB = Integer.parseInt(eqB);
        arbitro = Integer.parseInt(arb);
        golesA = Integer.parseInt(ga);
        golesB = Integer.parseInt(gb);
        ubicacion = ubi;

    }
}
