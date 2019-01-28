package com.example.mac.attractie_nl;

public class Images {

    public String NaamPark;
    public String logoLocation;
    public String Plaats;
    public static String Lat;
    public static String Lng;


    public Images(String naamPark, String Plaats, String Lat, String Lng, String logoLocation) {
        this.setNaamPark(naamPark);
        this.setPlaats(Plaats);
        this.setLat(Lat);
        this.setLng(Lng);
        this.setLogoLocation(logoLocation);
    }

    public String getNaamPark() {
        return NaamPark;
    }

    public void setNaamPark(String naamPark) {
        NaamPark = naamPark;
    }

    public String getPlaats() {
        return Plaats;
    }

    public void setPlaats(String plaats) {
        Plaats = plaats;
    }


    public static String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public static String getLng() {
        return Lng;
    }

    public void setLng(String lng) {
        Lng = lng;
    }

    public String getLogoLocation() {
        return logoLocation;
    }

    public void setLogoLocation(String logoLocation) {
        this.logoLocation = logoLocation;
    }
}
