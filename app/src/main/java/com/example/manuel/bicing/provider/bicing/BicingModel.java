package com.example.manuel.bicing.provider.bicing;

import com.example.manuel.bicing.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code bicing} table.
 */
public interface BicingModel extends BaseModel {

    /**
     * Get the {@code type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getType();

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLatitude();

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLongitude();

    /**
     * Get the {@code street_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStreetName();

    /**
     * Get the {@code street_number} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStreetNumber();

    /**
     * Get the {@code altitude} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAltitude();

    /**
     * Get the {@code slots} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSlots();

    /**
     * Get the {@code bikes} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBikes();

    /**
     * Get the {@code nearby_station} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNearbyStation();

    /**
     * Get the {@code status} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStatus();
}
