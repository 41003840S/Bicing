package com.example.manuel.bicing;

import android.content.Context;
import android.util.Log;

import com.example.manuel.bicing.bicing.Example;
import com.example.manuel.bicing.bicing.Station;
import com.example.manuel.bicing.provider.bicing.BicingColumns;
import com.example.manuel.bicing.provider.bicing.BicingContentValues;

import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;


//Interfaz
interface InterfazLlamadaBicing {

    @GET("stations")
    Call<Example> stations();
}

public class RetroFit {

    private final InterfazLlamadaBicing service;
    private final String BASE_URL = "http://wservice.viabicing.cat/v2/stations";

    //Constructor de la clase con el builder
    public RetroFit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(InterfazLlamadaBicing.class);
    }

    //Metodo que hace la llamada a la API
    public void downloadStations (final Context context) {

        //Llamada al servicio con el metodo de la interfaz
        Call<Example> llamadaBicing = service.stations();

        //Cuando recibe la respuesta la pone en cola
        llamadaBicing.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Response<Example> response, Retrofit retrofit) {

                Example estacion = response.body();

                for (Station station : estacion.getStations()) {

                    BicingContentValues valores = new BicingContentValues();

                    valores.putType(station.getType());
                    valores.putLatitude(station.getLatitude());
                    valores.putLongitude(station.getLongitude());
                    valores.putStreetName(station.getStreetName());
                    valores.putStreetNumber(station.getStreetNumber());
                    valores.putAltitude(station.getAltitude());
                    valores.putSlots(station.getSlots());
                    valores.putBikes(station.getBikes());
                    valores.putNearbyStation(station.getNearbyStations());
                    valores.putStatus(station.getStatus());

                    context.getContentResolver().insert(BicingColumns.CONTENT_URI, valores.values());
                }

            }
            @Override
            public void onFailure(Throwable t) {
                Log.e("Update characater", Arrays.toString(t.getStackTrace()));
            }
        });
    }


}

