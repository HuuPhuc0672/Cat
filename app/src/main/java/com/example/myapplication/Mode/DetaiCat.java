package com.example.myapplication.Mode;

public class DetaiCat {
    public String name;
    public String cfa_url;
    public String vetstreet_url;
    public String vcahospitals_url;
    public String temperament;
    public String origin;

    public DetaiCat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCfa_url() {
        return cfa_url;
    }

    public void setCfa_url(String cfa_url) {
        this.cfa_url = cfa_url;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public void setVetstreet_url(String vetstreet_url) {
        this.vetstreet_url = vetstreet_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public void setVcahospitals_url(String vcahospitals_url) {
        this.vcahospitals_url = vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public DetaiCat(String name, String cfa_url, String vetstreet_url, String vcahospitals_url, String temperament, String origin) {
        this.name = name;
        this.cfa_url = cfa_url;
        this.vetstreet_url = vetstreet_url;
        this.vcahospitals_url = vcahospitals_url;
        this.temperament = temperament;
        this.origin = origin;
    }
}
