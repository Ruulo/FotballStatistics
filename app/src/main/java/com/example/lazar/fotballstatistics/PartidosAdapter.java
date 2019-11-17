package com.example.lazar.fotballstatistics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PartidosAdapter extends BaseAdapter {

    protected Activity activity;
    ArrayList<Partido> partidos = new ArrayList<Partido>();

    public PartidosAdapter(Activity a, ArrayList<Partido> par){
        activity = a;
        partidos = par;
    }

    @Override
    public int getCount() {
        return partidos.size();
    }

    @Override
    public Object getItem(int i) {
        return partidos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v = view;
        if (view == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.partido, null);
        }
        Partido p = partidos.get(i);

        ImageView eA = (ImageView) v.findViewById(R.id.eA);
        ImageView eB = (ImageView) v.findViewById(R.id.eB);
        TextView eAn = (TextView) v.findViewById(R.id.eAn);
        TextView eBn = (TextView) v.findViewById(R.id.eBn);

        eA.setImageBitmap(db.equipos.get(p.idEquipoA).escudo);
        eB.setImageBitmap(db.equipos.get(p.idEquipoB).escudo);

        eAn.setText(db.equipos.get(p.idEquipoA).nombre);
        eBn.setText(db.equipos.get(p.idEquipoB).nombre);

        return v;
    }
}
