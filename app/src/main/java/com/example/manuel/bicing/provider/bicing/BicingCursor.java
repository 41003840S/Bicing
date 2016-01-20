package com.example.manuel.bicing.provider.bicing;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.bicing.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code bicing} table.
 */
public class BicingCursor extends AbstractCursor implements BicingModel {
    public BicingCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(BicingColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getType() {
        String res = getStringOrNull(BicingColumns.TYPE);
        return res;
    }

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLatitude() {
        String res = getStringOrNull(BicingColumns.LATITUDE);
        return res;
    }

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLongitude() {
        String res = getStringOrNull(BicingColumns.LONGITUDE);
        return res;
    }

    /**
     * Get the {@code street_name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStreetName() {
        String res = getStringOrNull(BicingColumns.STREET_NAME);
        return res;
    }

    /**
     * Get the {@code street_number} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStreetNumber() {
        String res = getStringOrNull(BicingColumns.STREET_NUMBER);
        return res;
    }

    /**
     * Get the {@code altitude} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getAltitude() {
        String res = getStringOrNull(BicingColumns.ALTITUDE);
        return res;
    }

    /**
     * Get the {@code slots} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSlots() {
        String res = getStringOrNull(BicingColumns.SLOTS);
        return res;
    }

    /**
     * Get the {@code bikes} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBikes() {
        String res = getStringOrNull(BicingColumns.BIKES);
        return res;
    }

    /**
     * Get the {@code nearby_station} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getNearbyStation() {
        String res = getStringOrNull(BicingColumns.NEARBY_STATION);
        return res;
    }

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStatus() {
        String res = getStringOrNull(BicingColumns.STATUS);
        return res;
    }
}
