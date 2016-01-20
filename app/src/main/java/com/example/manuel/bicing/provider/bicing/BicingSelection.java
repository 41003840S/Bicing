package com.example.manuel.bicing.provider.bicing;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.bicing.provider.base.AbstractSelection;

/**
 * Selection for the {@code bicing} table.
 */
public class BicingSelection extends AbstractSelection<BicingSelection> {
    @Override
    protected Uri baseUri() {
        return BicingColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BicingCursor} object, which is positioned before the first entry, or null.
     */
    public BicingCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BicingCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public BicingCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code BicingCursor} object, which is positioned before the first entry, or null.
     */
    public BicingCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new BicingCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public BicingCursor query(Context context) {
        return query(context, null);
    }


    public BicingSelection id(long... value) {
        addEquals("bicing." + BicingColumns._ID, toObjectArray(value));
        return this;
    }

    public BicingSelection idNot(long... value) {
        addNotEquals("bicing." + BicingColumns._ID, toObjectArray(value));
        return this;
    }

    public BicingSelection orderById(boolean desc) {
        orderBy("bicing." + BicingColumns._ID, desc);
        return this;
    }

    public BicingSelection orderById() {
        return orderById(false);
    }

    public BicingSelection type(String... value) {
        addEquals(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection typeNot(String... value) {
        addNotEquals(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection typeLike(String... value) {
        addLike(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection typeContains(String... value) {
        addContains(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection typeStartsWith(String... value) {
        addStartsWith(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection typeEndsWith(String... value) {
        addEndsWith(BicingColumns.TYPE, value);
        return this;
    }

    public BicingSelection orderByType(boolean desc) {
        orderBy(BicingColumns.TYPE, desc);
        return this;
    }

    public BicingSelection orderByType() {
        orderBy(BicingColumns.TYPE, false);
        return this;
    }

    public BicingSelection latitude(String... value) {
        addEquals(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection latitudeNot(String... value) {
        addNotEquals(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection latitudeLike(String... value) {
        addLike(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection latitudeContains(String... value) {
        addContains(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection latitudeStartsWith(String... value) {
        addStartsWith(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection latitudeEndsWith(String... value) {
        addEndsWith(BicingColumns.LATITUDE, value);
        return this;
    }

    public BicingSelection orderByLatitude(boolean desc) {
        orderBy(BicingColumns.LATITUDE, desc);
        return this;
    }

    public BicingSelection orderByLatitude() {
        orderBy(BicingColumns.LATITUDE, false);
        return this;
    }

    public BicingSelection longitude(String... value) {
        addEquals(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection longitudeNot(String... value) {
        addNotEquals(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection longitudeLike(String... value) {
        addLike(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection longitudeContains(String... value) {
        addContains(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection longitudeStartsWith(String... value) {
        addStartsWith(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection longitudeEndsWith(String... value) {
        addEndsWith(BicingColumns.LONGITUDE, value);
        return this;
    }

    public BicingSelection orderByLongitude(boolean desc) {
        orderBy(BicingColumns.LONGITUDE, desc);
        return this;
    }

    public BicingSelection orderByLongitude() {
        orderBy(BicingColumns.LONGITUDE, false);
        return this;
    }

    public BicingSelection streetName(String... value) {
        addEquals(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection streetNameNot(String... value) {
        addNotEquals(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection streetNameLike(String... value) {
        addLike(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection streetNameContains(String... value) {
        addContains(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection streetNameStartsWith(String... value) {
        addStartsWith(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection streetNameEndsWith(String... value) {
        addEndsWith(BicingColumns.STREET_NAME, value);
        return this;
    }

    public BicingSelection orderByStreetName(boolean desc) {
        orderBy(BicingColumns.STREET_NAME, desc);
        return this;
    }

    public BicingSelection orderByStreetName() {
        orderBy(BicingColumns.STREET_NAME, false);
        return this;
    }

    public BicingSelection streetNumber(String... value) {
        addEquals(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection streetNumberNot(String... value) {
        addNotEquals(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection streetNumberLike(String... value) {
        addLike(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection streetNumberContains(String... value) {
        addContains(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection streetNumberStartsWith(String... value) {
        addStartsWith(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection streetNumberEndsWith(String... value) {
        addEndsWith(BicingColumns.STREET_NUMBER, value);
        return this;
    }

    public BicingSelection orderByStreetNumber(boolean desc) {
        orderBy(BicingColumns.STREET_NUMBER, desc);
        return this;
    }

    public BicingSelection orderByStreetNumber() {
        orderBy(BicingColumns.STREET_NUMBER, false);
        return this;
    }

    public BicingSelection altitude(String... value) {
        addEquals(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection altitudeNot(String... value) {
        addNotEquals(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection altitudeLike(String... value) {
        addLike(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection altitudeContains(String... value) {
        addContains(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection altitudeStartsWith(String... value) {
        addStartsWith(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection altitudeEndsWith(String... value) {
        addEndsWith(BicingColumns.ALTITUDE, value);
        return this;
    }

    public BicingSelection orderByAltitude(boolean desc) {
        orderBy(BicingColumns.ALTITUDE, desc);
        return this;
    }

    public BicingSelection orderByAltitude() {
        orderBy(BicingColumns.ALTITUDE, false);
        return this;
    }

    public BicingSelection slots(String... value) {
        addEquals(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection slotsNot(String... value) {
        addNotEquals(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection slotsLike(String... value) {
        addLike(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection slotsContains(String... value) {
        addContains(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection slotsStartsWith(String... value) {
        addStartsWith(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection slotsEndsWith(String... value) {
        addEndsWith(BicingColumns.SLOTS, value);
        return this;
    }

    public BicingSelection orderBySlots(boolean desc) {
        orderBy(BicingColumns.SLOTS, desc);
        return this;
    }

    public BicingSelection orderBySlots() {
        orderBy(BicingColumns.SLOTS, false);
        return this;
    }

    public BicingSelection bikes(String... value) {
        addEquals(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection bikesNot(String... value) {
        addNotEquals(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection bikesLike(String... value) {
        addLike(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection bikesContains(String... value) {
        addContains(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection bikesStartsWith(String... value) {
        addStartsWith(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection bikesEndsWith(String... value) {
        addEndsWith(BicingColumns.BIKES, value);
        return this;
    }

    public BicingSelection orderByBikes(boolean desc) {
        orderBy(BicingColumns.BIKES, desc);
        return this;
    }

    public BicingSelection orderByBikes() {
        orderBy(BicingColumns.BIKES, false);
        return this;
    }

    public BicingSelection nearbyStation(String... value) {
        addEquals(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection nearbyStationNot(String... value) {
        addNotEquals(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection nearbyStationLike(String... value) {
        addLike(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection nearbyStationContains(String... value) {
        addContains(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection nearbyStationStartsWith(String... value) {
        addStartsWith(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection nearbyStationEndsWith(String... value) {
        addEndsWith(BicingColumns.NEARBY_STATION, value);
        return this;
    }

    public BicingSelection orderByNearbyStation(boolean desc) {
        orderBy(BicingColumns.NEARBY_STATION, desc);
        return this;
    }

    public BicingSelection orderByNearbyStation() {
        orderBy(BicingColumns.NEARBY_STATION, false);
        return this;
    }

    public BicingSelection status(String... value) {
        addEquals(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection statusNot(String... value) {
        addNotEquals(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection statusLike(String... value) {
        addLike(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection statusContains(String... value) {
        addContains(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection statusStartsWith(String... value) {
        addStartsWith(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection statusEndsWith(String... value) {
        addEndsWith(BicingColumns.STATUS, value);
        return this;
    }

    public BicingSelection orderByStatus(boolean desc) {
        orderBy(BicingColumns.STATUS, desc);
        return this;
    }

    public BicingSelection orderByStatus() {
        orderBy(BicingColumns.STATUS, false);
        return this;
    }
}
