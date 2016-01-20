package com.example.manuel.bicing.bicing;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("stations")
    @Expose
    private List<Station> stations = new ArrayList<Station>();

    /**
     *
     * @return
     * The stations
     */
    public List<Station> getStations() {
        return stations;
    }

    /**
     *
     * @param stations
     * The stations
     */
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

}