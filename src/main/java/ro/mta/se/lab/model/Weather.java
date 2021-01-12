package ro.mta.se.lab.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Weather {

    String Country;
    String City;

    Double Lon;
    Double Lat;

    String Weather_type;
    String Weather_description;

    Double Temperature;
    Double Temp_min;
    Double Temp_max;

    Integer Pressure;
    Integer Humidity;

    Integer Visibility;

    Integer Wind_speed;


    public Weather()
    {
        Lon = 0.0;
        Lat = 0.0;

    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public Double getLon() {
        return Lon;
    }

    public void setLon(Double lon) {
        this.Lon = lon;
    }

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        this.Lat = lat;
    }

    public String getWeatherType() {
        return Weather_type;
    }

    public void setWeatherType(String type) {
        this.Weather_type = type;
    }

    public String getWeatherDesc() {
        return Weather_description;
    }

    public void setWeatherDesc(String desc) {
        this.Weather_description = desc;
    }

    public Double getTemp() {
        return Temperature;
    }

    public void setTemp(Double temp) {
        this.Temperature = temp;
    }

    public Double getTempMin() {
        return Temp_min;
    }

    public void setTempMin(Double temp_min) {
        this.Temp_min = temp_min;
    }

    public Double getTempMax() {
        return Temp_max;
    }

    public void setTempMax(Double temp_max) {
        this.Temp_max = temp_max;
    }

    public Integer getPress() {
        return Pressure;
    }

    public void setPress(Integer pressure) {
        this.Pressure = pressure;
    }

    public Integer getHumid() {
        return Humidity;
    }

    public void setHumid(Integer humidity) {
        this.Humidity = humidity;
    }

    public Integer getVisib() {
        return Visibility;
    }

    public void setVisib(Integer visibil) {
        this.Visibility = visibil;
    }

    public Integer getWindspd() {
        return Wind_speed;
    }

    public void setWindspd(Integer wind_speed) {
        this.Wind_speed = wind_speed;
    }

}
