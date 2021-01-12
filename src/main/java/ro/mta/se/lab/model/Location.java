package ro.mta.se.lab.model;

public class Location {

    String Country;
    String City;

    Double Lon;
    Double Lat;

    public Location(String country, String city, Double lon, Double lat)
    {
        this.Country = country;
        this.City = city;
        this.Lon = lon;
        this.Lat = lat;
    }

    public String getCountry()
    {
        return Country;
    }

    public String getCity()
    {
        return City;
    }

    public Double getLon()
    {
        return Lon;
    }

    public Double getLat()
    {
        return Lat;
    }

}
