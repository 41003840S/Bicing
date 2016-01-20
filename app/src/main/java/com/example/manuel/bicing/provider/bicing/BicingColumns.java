package com.example.manuel.bicing.provider.bicing;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.bicing.provider.BicingProvider;
import com.example.manuel.bicing.provider.bicing.BicingColumns;

/**
 * Columns for the {@code bicing} table.
 */
public class BicingColumns implements BaseColumns {
    public static final String TABLE_NAME = "bicing";
    public static final Uri CONTENT_URI = Uri.parse(BicingProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TYPE = "type";

    public static final String LATITUDE = "latitude";

    public static final String LONGITUDE = "longitude";

    public static final String STREET_NAME = "street_name";

    public static final String STREET_NUMBER = "street_number";

    public static final String ALTITUDE = "altitude";

    public static final String SLOTS = "slots";

    public static final String BIKES = "bikes";

    public static final String NEARBY_STATION = "nearby_station";

    public static final String STATUS = "status";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TYPE,
            LATITUDE,
            LONGITUDE,
            STREET_NAME,
            STREET_NUMBER,
            ALTITUDE,
            SLOTS,
            BIKES,
            NEARBY_STATION,
            STATUS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TYPE) || c.contains("." + TYPE)) return true;
            if (c.equals(LATITUDE) || c.contains("." + LATITUDE)) return true;
            if (c.equals(LONGITUDE) || c.contains("." + LONGITUDE)) return true;
            if (c.equals(STREET_NAME) || c.contains("." + STREET_NAME)) return true;
            if (c.equals(STREET_NUMBER) || c.contains("." + STREET_NUMBER)) return true;
            if (c.equals(ALTITUDE) || c.contains("." + ALTITUDE)) return true;
            if (c.equals(SLOTS) || c.contains("." + SLOTS)) return true;
            if (c.equals(BIKES) || c.contains("." + BIKES)) return true;
            if (c.equals(NEARBY_STATION) || c.contains("." + NEARBY_STATION)) return true;
            if (c.equals(STATUS) || c.contains("." + STATUS)) return true;
        }
        return false;
    }

}
