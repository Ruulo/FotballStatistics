package com.example.lazar.fotballstatistics;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class db {

    static HashMap<Integer, Equipo> equipos = new HashMap<>();
    static HashMap<Integer, Partido> partidos = new HashMap<>();

    static void loadPartido(int id, loaderPartido lp){
        final loaderPartido lpf = lp;
        if (partidos.get(id) == null) {
            try {

                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://cascaritaapp.000webhostapp.com/webservice/partido.php?id=" + id, new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        // called before request is started
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        // called when response HTTP status is "200 OK"

                        String st = new String(response);

                        ObjectMapper mapper = new ObjectMapper();
                        Map<String, String> map = null;
                        try {
                            map = mapper.readValue(st, Map.class);
                            Partido p = new Partido(map.get("idPartido"), map.get("equipoA"), map.get("equipoB"), map.get("arbitro"), map.get("Ubicacion"), map.get("golesA"), map.get("golesB"));
                            partidos.put(Integer.parseInt(map.get("idPartido")), p);
                            lpf.setReady();
                            loadEquipo(p.idEquipoA, lpf);
                            loadEquipo(p.idEquipoB, lpf);
                        } catch (IOException e) {
                            e.printStackTrace();

                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        // called when request is retried
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            lpf.setReady();
            loadEquipo(partidos.get(id).idEquipoA, lpf);
            loadEquipo(partidos.get(id).idEquipoB, lpf);
        }
    }

    static void loadEquipo(int id, loaderPartido lp){
        final loaderPartido lpf = lp;
        if(equipos.get(id) == null){
            try {
                AsyncHttpClient client = new AsyncHttpClient();
                client.get("https://cascaritaapp.000webhostapp.com/webservice/equipo.php?id=" + id, new AsyncHttpResponseHandler() {

                    @Override
                    public void onStart() {
                        // called before request is started
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                        // called when response HTTP status is "200 OK"
                        String st = new String(response);
                        Log.d("TEST", "x: " + st);
                        ObjectMapper mapper = new ObjectMapper();
                        Map<String, String> map = null;
                        try {
                            map = mapper.readValue(st, Map.class);
                            Equipo e = new Equipo(map.get("nombre"), map.get("escudo"));
                            equipos.put(Integer.valueOf(map.get("idEquipo")),e);
                            Log.d("TEST", map.get("idEquipo"));
                            lpf.setReady();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                        // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                    }

                    @Override
                    public void onRetry(int retryNo) {
                        // called when request is retried
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            lpf.setReady();
        }

    }



}
