package com.mobile.yeschurch;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final LatLng bogota = new LatLng(4.6680082, -74.1016931);
    public static final float PREFERED_ZOOM = 13;


    public static List<Church> christianChurches = new ArrayList<>();
    public static List<Church> catholicChurches = new ArrayList<>();
    public static List<Church> bauptistChurches = new ArrayList<>();
    public static List<Church> otherChurches = new ArrayList<>();

    static {
        christianChurches.add(new Church("Iglesia El Lugar de Su Presencia", new LatLng(4.684825,-74.062669), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana La Libertad", new LatLng(4.677096, -74.082354), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Philadelphia JV", new LatLng(4.642072, -74.113905), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Casa sobre la Roca", new LatLng(4.686576, -74.046072), "Bogota", ChurchType.Christian));
        catholicChurches.add(new Church("San Alberto Magno", new LatLng(4.673092, -74.0865433), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Santos Timoteo y Tito", new LatLng(4.690770, -74.075008), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("San Felipe Apostol Parish", new LatLng(4.669597, -74.098599), "Bogota", ChurchType.Catholic));
        bauptistChurches.add(new Church("Iglesia Bautista Nueva Vida", new LatLng(4.681075, -74.101765), "Bogota", ChurchType.Bauptist));
    }

}
