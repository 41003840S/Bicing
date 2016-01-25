package com.example.manuel.bicing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.manuel.bicing.provider.bicing.BicingColumns;
import com.example.manuel.bicing.provider.bicing.BicingCursor;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        long estacion_id = this.getIntent().getLongExtra("id", -1);


       // if(estacion_id  == -1){

            Cursor cursor = this.getContentResolver().query(
                    BicingColumns.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);

            BicingCursor estacionCursor = new BicingCursor(cursor);

            while (estacionCursor.moveToNext()) {

                double latitud = Double.parseDouble(estacionCursor.getLatitude());
                double longitud = Double.parseDouble(estacionCursor.getLongitude());
                LatLng estacion = new LatLng(latitud, longitud);

                if (Integer.parseInt(estacionCursor.getSlots()) >= 5) {
                    mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bike)).position(estacion).title(
                                    estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                    );

                } else if (Integer.parseInt(estacionCursor.getSlots()) < 5 && Integer.parseInt(estacionCursor.getSlots()) > 0) {
                    mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bikeyellow)).position(estacion).title(
                                    estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                    );
                } else {
                    mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bikered)).position(estacion).title(
                                    estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                    );
                }

            }

       /* }else if(estacion_id  > -1){

            Cursor cursor = this.getContentResolver().query(
                    BicingColumns.CONTENT_URI,
                    null,
                    BicingColumns._ID + " = ?",
                    new String[]{String.valueOf(estacion_id)},
                    null);

            BicingCursor estacionCursor = new BicingCursor(cursor);
            double latitud = Double.parseDouble(estacionCursor.getLatitude());
            double longitud = Double.parseDouble(estacionCursor.getLongitude());
            LatLng estacion = new LatLng(latitud, longitud);

            if (Integer.parseInt(estacionCursor.getSlots()) >= 5) {
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bike)).position(estacion).title(
                                estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                );

            } else if (Integer.parseInt(estacionCursor.getSlots()) < 5 && Integer.parseInt(estacionCursor.getSlots()) > 0) {
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bikeyellow)).position(estacion).title(
                                estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                );
            } else {
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.bikered)).position(estacion).title(
                                estacionCursor.getStreetName() + ", " + estacionCursor.getStreetNumber())
                );
            }
        }*/

            //Para mostrar tu posicion
            mMap.setMyLocationEnabled(true);
        }
    }


