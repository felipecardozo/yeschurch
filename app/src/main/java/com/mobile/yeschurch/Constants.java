package com.mobile.yeschurch;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final LatLng bogota = new LatLng(4.6680082, -74.1016931);
    public static final float PREFERED_ZOOM = 13;


    public static List<Church> christianChurchs = new ArrayList<>();
    public static List<Church> catholicChurchs = new ArrayList<>();

    static {
        christianChurchs.add(new Church("Su Presencia", new LatLng(4.6896509,-74.0624255), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Filadelfia JV", new LatLng(4.6399485,-74.1139239), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Filadelfia JV", new LatLng(4.6399485,-74.1139239), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Casa sobre la Roca", new LatLng(4.6796957,-74.0716737), "Bogota", ChurchType.Christian));
        catholicChurchs.add(new Church("San Alberto Magno", new LatLng(4.6796957,-74.0716737), "Bogota", ChurchType.Catholic));
        catholicChurchs.add(new Church("Parroquia Santos Timoteo y Tito", new LatLng(4.6796957,-74.0716737), "Bogota", ChurchType.Catholic));
        catholicChurchs.add(new Church("San Felipe Apostol Parish", new LatLng(4.6757606,-74.0913718), "Bogota", ChurchType.Catholic));
    }

}
