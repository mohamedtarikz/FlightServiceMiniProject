package airline;

public class Location {
    final String city, country;

    public Location(String city, String country) {
        this.city = city.toUpperCase();
        this.country = country.toUpperCase();
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
