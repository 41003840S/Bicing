package com.example.manuel.bicing;


import android.content.Context;
import android.database.Cursor;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.manuel.bicing.provider.bicing.BicingCursor;

public class AdaptadorEstaciones extends SimpleCursorAdapter {

    TextView tipo, latitud, longitud, parada, numerocalle, altitud, slots, bicis, estacionesCercanas, status;
    Context context;

    public AdaptadorEstaciones(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Cursor myCursor = getCursor();
        BicingCursor cursorEstaciones = new BicingCursor(myCursor);
        cursorEstaciones.moveToPosition(position);

        //Miramos si la View la esta reusando, sino es asi hinchamos la vista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.station_row, parent, false);
        }

        //Enlazamos las variables con las ids
        parada = (TextView) convertView.findViewById(R.id.tvParada);
        slots = (TextView) convertView.findViewById(R.id.tvSlots);
        bicis = (TextView) convertView.findViewById(R.id.tvBikes);
        status = (TextView) convertView.findViewById(R.id.tvStatus);
        estacionesCercanas = (TextView) convertView.findViewById(R.id.tvNearbyStations);

        //Metemos los datos de los objetos provinientes de la BD en el layout
        parada.setText( "["+cursorEstaciones.getId()+"]  " + cursorEstaciones.getStreetName() + ", " + cursorEstaciones.getStreetNumber());
        slots.setText(cursorEstaciones.getSlots());
        bicis.setText(cursorEstaciones.getBikes());
        status.setText(cursorEstaciones.getStatus());
        estacionesCercanas.setText(cursorEstaciones.getNearbyStation());

        //tipo.setText(cursorEstaciones.getType());
        //latitud.setText(cursorEstaciones.getLatitude());
        //longitud.setText(cursorEstaciones.getLongitude());
        //numerocalle.setText(cursorEstaciones.getStreetNumber());
        //altitud.setText(cursorEstaciones.getAltitude());

        return convertView;
    }
}
