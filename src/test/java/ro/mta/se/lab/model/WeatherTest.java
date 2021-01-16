package ro.mta.se.lab.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static junit.framework.TestCase.assertEquals;

public class WeatherTest extends TestCase {

    private Weather model;
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


    @Before
    public void setUp() throws Exception {
        model = new Weather();

        model.setCity("Bucharest");
        model.setCountry("RO");
        model.setWindspd(3);
        model.setVisib(10000);
        model.setHumid(74);
        model.setPress(1016);
        model.setTemp(3.5);
        model.setTempMin(3.4);
        model.setTempMax(3.6);
        model.setWeatherType("Clear");
        model.setWeatherDesc("clear sky");
        model.setLat(44.4323);
        model.setLon(26.1063);


        Country = "RO";
        City = "Bucharest";
        Lon = 26.1063;
        Lat = 44.4323;
        Weather_type = "Clear";
        Weather_description = "clear sky";
        Temperature = 3.5;
        Temp_min = 3.4;
        Temp_max = 3.6;
        Pressure = 1016;
        Humidity = 74;
        Visibility = 10000;
        Wind_speed = 3;

    }

    @Test
    public void getCountry() {
        assertEquals(model.getCountry(),this.Country);
    }

    @Test
    public void getCity() {
        assertEquals(model.getCity(),this.City);
    }

    @Test
    public void getLon() {
        assertEquals(model.getLon(),this.Lon);
    }

    @Test
    public void getLat() {
        assertEquals(model.getLat(),this.Lat);
    }

    @Test
    public void getWeatherType() {
        assertEquals(model.getWeatherType(),this.Weather_type);
    }

    @Test
    public void getWeatherDesc() {
        assertEquals(model.getWeatherDesc(),this.Weather_description);
    }

    @Test
    public void getTemp() {
        assertEquals(model.getTemp(),this.Temperature);
    }

    @Test
    public void getTempMin() {
        assertEquals(model.getTempMin(),this.Temp_min);
    }

    @Test
    public void getTempMax() {
        assertEquals(model.getTempMax(),this.Temp_max);
    }

    @Test
    public void getPress() {
        assertEquals(model.getPress(),this.Pressure);
    }

    @Test
    public void getHumid() {
        assertEquals(model.getHumid(),this.Humidity);
    }

    @Test
    public void getVisib() {
        assertEquals(model.getVisib(),this.Visibility);
    }

    @Test
    public void getWindspd() {
        assertEquals(model.getWindspd(),this.Wind_speed);
    }

}