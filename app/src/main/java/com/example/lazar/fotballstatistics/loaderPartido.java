package com.example.lazar.fotballstatistics;

public class loaderPartido {

    int ready = 0;
    Partidos men;
    int partido;

    public loaderPartido(int partido, Partidos m){
        men = m;
        this.partido = partido;
        db.loadPartido(partido, this);

    }

    public void setReady() {

        if(ready == 2){
            men.addPartido(db.partidos.get(partido));
        }else{

        }
        ready++;
    }
}