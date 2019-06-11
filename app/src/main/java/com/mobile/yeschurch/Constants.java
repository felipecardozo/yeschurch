package com.mobile.yeschurch;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final LatLng bogota = new LatLng(4.6799702,-74.1009756);
    public static final float PREFERED_ZOOM = 12;


    public static List<Church> christianChurches = new ArrayList<>();
    public static List<Church> catholicChurches = new ArrayList<>();
    public static List<Church> bauptistChurches = new ArrayList<>();
    public static List<Church> otherChurches = new ArrayList<>();

    static {
        christianChurches.add(new Church("Iglesia El Lugar de Su Presencia", new LatLng(4.684825,-74.062669), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana La Libertad", new LatLng(4.677096, -74.082354), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Philadelphia JV", new LatLng(4.642072, -74.113905), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Casa sobre la Roca", new LatLng(4.686576, -74.046072), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Centro Mundial de Avivamiento", new LatLng(4.639043, -74.115883), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana El Rio", new LatLng(4.698529, -74.032709), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana de Colombia - RHEMA Colombia", new LatLng(4.712622, -74.056652), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Palabra y Fuego", new LatLng(4.744370, -74.046784), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Del Cielo al Mundo", new LatLng(4.752837, -74.091367), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia de Dios Ministerial de Jesucristo Internacional - IDMJI - CGMJI -- BGT - PINAR DE SUBA", new LatLng(4.747317, -74.084835), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Filadelfia Suba", new LatLng(4.744350, -74.106524), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana La Gloria Postrera", new LatLng(4.713479, -74.098432), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Amor Y Restauracion", new LatLng(4.714568, -74.070123), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Comunidad Cristiana Carismática La Esperanza", new LatLng(4.663932, -74.117450), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana El Remanente", new LatLng(4.624771, -74.148070), "Bogota", ChurchType.Christian));christianChurches.add(new Church("Iglesia alianza cristiana y misionera colombiana el encuentro Kennedy", new LatLng(4.624, -74.133383), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana del Movimiento Misionero Mundial Barrio Olarte", new LatLng(4.600682, -74.166933), "Bogota", ChurchType.Christian));christianChurches.add(new Church("Iglesia alianza cristiana y misionera colombiana el encuentro Kennedy", new LatLng(4.624, -74.133383), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Fuente De Gloria Y Vida", new LatLng(4.581260, -74.154059), "Bogota", ChurchType.Christian));christianChurches.add(new Church("Iglesia alianza cristiana y misionera colombiana el encuentro Kennedy", new LatLng(4.624, -74.133383), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia Cristiana Dios está formando un pueblo", new LatLng(4.633607, -74.074256), "Bogota", ChurchType.Christian));christianChurches.add(new Church("Iglesia alianza cristiana y misionera colombiana el encuentro Kennedy", new LatLng(4.624, -74.133383), "Bogota", ChurchType.Christian));
        christianChurches.add(new Church("Iglesia de Dios Ministerial de Jesucristo Internaciona", new LatLng(4.647233, -74.065698), "Bogota", ChurchType.Christian));christianChurches.add(new Church("Iglesia alianza cristiana y misionera colombiana el encuentro Kennedy", new LatLng(4.624, -74.133383), "Bogota", ChurchType.Christian));
        catholicChurches.add(new Church("San Alberto Magno", new LatLng(4.673092, -74.0865433), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Santos Timoteo y Tito", new LatLng(4.690770, -74.075008), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("San Felipe Apostol Parish", new LatLng(4.669597, -74.098599), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Señor de los milagros", new LatLng(4.628217, -74.077893), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia de la Epifania", new LatLng(4.634205, -74.093863), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia de la Epifania", new LatLng(4.634205, -74.093863), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia San Pio X", new LatLng(4.625865, -74.138840), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia San Mateo", new LatLng(4.677618, -74.078319), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("San Luis Beltran Parish", new LatLng(4.675245, -74.063480), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Santa Teresita del Nino Jesús", new LatLng(4.609256, -74.094732), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Nuestra Señora de las Angustias", new LatLng(4.611855, -74.073964), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia nuestra señora del perpetuo socorro", new LatLng(4.613053, -74.065982), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia La Sagrada Eucaristia", new LatLng(4.650817, -74.087914), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Santos Cosme Y Damian", new LatLng(4.626471, -74.088615), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Catedral Jesucristo Nuestra Paz", new LatLng(4.595376, -74.194914), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Católica del Quiroga", new LatLng(4.582026, -74.113714), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Nuestra Señora Del Carmen", new LatLng(4.594573, -74.074756), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia de la Concepcion", new LatLng(4.598747, -74.077472), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia de San Francisco", new LatLng(4.602044, -74.073315), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia Nuestra Señora de Chiquinquirá", new LatLng(4.638537, -74.065334), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Santa Marta", new LatLng(4.639687, -74.072450), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Iglesia Nuestra Señora de La Estrella", new LatLng(4.644299, -74.060160), "Bogota", ChurchType.Catholic));
        catholicChurches.add(new Church("Parroquia nuestra señora del Sagrado Corazón", new LatLng(4.628467, -74.066044), "Bogota", ChurchType.Catholic));
        bauptistChurches.add(new Church("Iglesia Bautista Nueva Vida", new LatLng(4.681075, -74.101765), "Bogota", ChurchType.Bauptist));
        bauptistChurches.add(new Church("Iglesia Bautista Soberana Gracia", new LatLng(4.666501, -74.065575), "Bogota", ChurchType.Bauptist));
        bauptistChurches.add(new Church("Iglesia Bautista del Norte", new LatLng(4.688410, -74.057323), "Bogota", ChurchType.Bauptist));
        bauptistChurches.add(new Church("Iglesia Biblica Bautista La mision", new LatLng(4.674696, -74.093906), "Bogota", ChurchType.Bauptist));
        bauptistChurches.add(new Church("Iglesia Bautista Nueva Vida", new LatLng(4.681219, -74.101759), "Bogota", ChurchType.Bauptist));
        otherChurches.add(new Church("La Iglesia de Jesucristo de los Santos de los últimos Dias", new LatLng(4.645736, -74.059447), "Bogota", ChurchType.Bauptist));
        otherChurches.add(new Church("Iglesia Episcopal En Colombia", new LatLng(4.636980, -74.062891), "Bogota", ChurchType.Bauptist));

    }

    static {
        //Iglesia el lugar de Su Presencia
        christianChurches.get(0).setKids(true);
        christianChurches.get(0).setParking(true);
        christianChurches.get(0).setBathrooms(true);
        christianChurches.get(0).setAccessibility(true);
        christianChurches.get(0).setSignLanguage(true);
        //la libertad
        christianChurches.get(1).setBathrooms(true);
        christianChurches.get(1).setParking(true);
        christianChurches.get(1).setAccessibility(true);
        //philadelphia
        christianChurches.get(2).setParking(true);
        christianChurches.get(2).setBathrooms(true);
        christianChurches.get(2).setAccessibility(true);
        //sobre la roca
        christianChurches.get(3).setBathrooms(true);
        christianChurches.get(3).setParking(true);
        christianChurches.get(3).setAccessibility(true);
        //Iglesia Centro Mundial de Avivamiento
        christianChurches.get(4).setParking(true);
        christianChurches.get(4).setAccessibility(true);
        christianChurches.get(4).setBathrooms(true);
    }

    static {
        //San Alberto Magno
        catholicChurches.get(0).setBathrooms(true);
        catholicChurches.get(0).setAccessibility(true);
        //Parroquia Santos Timoteo y Tito
        catholicChurches.get(1).setAccessibility(true);
        //San Felipe Apostol Parish
        catholicChurches.get(2).setBathrooms(true);
        catholicChurches.get(2).setAccessibility(true);
        //iglesia señor de los milagros
        catholicChurches.get(3).setAccessibility(true);
        catholicChurches.get(3).setBathrooms(true);
    }

    static {
        //Iglesia Bautista Nueva Vida
        bauptistChurches.get(0).setBathrooms(true);
        bauptistChurches.get(0).setAccessibility(true);
    }

}
