package com.airline;

public class Location {
    private String city;
    private String country;

    public Location(String city, String country){
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }
    public String getCountry() {
        return this.country;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
