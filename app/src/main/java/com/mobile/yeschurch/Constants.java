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
        christianChurchs.add(new Church("Su Presencia", new LatLng(4.6837269,-74.0654724), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Iglesia Cristiana La Libertad", new LatLng(4.6741032,-74.0837114), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Filadelfia JV", new LatLng(4.6420122,-74.1172068), "Bogota", ChurchType.Christian));
        christianChurchs.add(new Church("Casa sobre la Roca", new LatLng(4.6857692,-74.0524475), "Bogota", ChurchType.Christian));
        catholicChurchs.add(new Church("San Alberto Magno", new LatLng(4.6796957,-74.0716737), "Bogota", ChurchType.Catholic));
        catholicChurchs.add(new Church("Parroquia Santos Timoteo y Tito", new LatLng(4.6796957,-74.0716737), "Bogota", ChurchType.Catholic));
        catholicChurchs.add(new Church("San Felipe Apostol Parish", new LatLng(4.6757606,-74.0913718), "Bogota", ChurchType.Catholic));
    }

}
