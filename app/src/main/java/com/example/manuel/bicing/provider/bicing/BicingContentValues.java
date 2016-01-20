package com.example.manuel.bicing.provider.bicing;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.bicing.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code bicing} table.
 */
public class BicingContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return BicingColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable BicingSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable BicingSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public BicingContentValues putType(@Nullable String value) {
        mContentValues.put(BicingColumns.TYPE, value);
        return this;
    }

    public BicingContentValues putTypeNull() {
        mContentValues.putNull(BicingColumns.TYPE);
        return this;
    }

    public BicingContentValues putLatitude(@Nullable String value) {
        mContentValues.put(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingContentValues putLatitudeNull() {
        mContentValues.putNull(BicingColumns.LATITUDE);
        return this;
    }

    public BicingContentValues putLongitude(@Nullable String value) {
        mContentValues.put(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingContentValues putLongitudeNull() {
        mContentValues.putNull(BicingColumns.LONGITUDE);
        return this;
    }

    public BicingContentValues putStreetName(@Nullable String value) {
        mContentValues.put(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingContentValues putStreetNameNull() {
        mContentValues.putNull(BicingColumns.STREET_NAME);
        return this;
    }

    public BicingContentValues putStreetNumber(@Nullable String value) {
        mContentValues.put(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingContentValues putStreetNumberNull() {
        mContentValues.putNull(BicingColumns.STREET_NUMBER);
        return this;
    }

    public BicingContentValues putAltitude(@Nullable String value) {
        mContentValues.put(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingContentValues putAltitudeNull() {
        mContentValues.putNull(BicingColumns.ALTITUDE);
        return this;
    }

    public BicingContentValues putSlots(@Nullable String value) {
        mContentValues.put(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingContentValues putSlotsNull() {
        mContentValues.putNull(BicingColumns.SLOTS);
        return this;
    }

    public BicingContentValues putBikes(@Nullable String value) {
        mContentValues.put(BicingColumns.BIKES, value);
        return this;
    }

    public BicingContentValues putBikesNull() {
        mContentValues.putNull(BicingColumns.BIKES);
        return this;
    }

    public BicingContentValues putNearbyStation(@Nullable String value) {
        mContentValues.put(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingContentValues putNearbyStationNull() {
        mContentValues.putNull(BicingColumns.NEARBY_STATION);
        return this;
    }

    public BicingContentValues putStatus(@Nullable String value) {
        mContentValues.put(BicingColumns.STATUS, value);
        return this;
    }

    public BicingContentValues putStatusNull() {
        mContentValues.putNull(BicingColumns.STATUS);
        return this;
    }
}
