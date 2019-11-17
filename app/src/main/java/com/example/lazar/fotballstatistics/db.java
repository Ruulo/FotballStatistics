package com.example.lazar.fotballstatistics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class db {

    static HashMap<Integer, Equipo> equipos = new HashMap<>();
    static HashMap<Integer, Partido> partidos = new HashMap<>();

    static Partido getPartido(int id){
        Partido p = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            URL url = new URL("http://localhost/cascarita/webservice/partido.php?id=" + String.valueOf(id));
            URLConnection urlc = (URLConnection) url.openConnection();

            BufferedReader bis = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

            Map<String, String> map = mapper.readValue(bis.readLine(), Map.class);

            p = new Partido(map.get("idPartido"), map.get("equipoA"), map.get("equipoB"), map.get("arbitro"), map.get("Ubicacion"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return p;
    }

    static Equipo getEquipo(int id){
        Equipo eq = null;
        try {
            ObjectMapper mapper = new ObjectMapper();

            URL url = new URL("http://localhost/cascarita/webservice/equipo.php?id=" + String.valueOf(id));
            URLConnection urlc = (URLConnection) url.openConnection();

            BufferedReader bis = new BufferedReader(new InputStreamReader(urlc.getInputStream()));

            Map<String, String> map = mapper.readValue(bis.readLine(), Map.class);
            eq = new Equipo(map.get("nombre"), map.get("escudo"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return eq;
    }

}
