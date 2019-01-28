package com.example.mac.attractie_nl;

public class Images {

    public String NaamPark, logoLocation;

    public Images(String naam, String logoLocation){
        this.setnaam(naam);
        this.setlogoLocation(logoLocation);
    }

    public void setlogoLocation(String logoLocation) {
        this.logoLocation = logoLocation;
    }

    public void setnaam(String naam) {
        this.NaamPark = naam;
    }

    public String getNaam() {
        return NaamPark;
    }

    public String getLogoLocation() {
        return logoLocation;
    }




}
