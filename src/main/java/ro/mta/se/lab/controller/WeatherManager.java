package ro.mta.se.lab.controller;


import ro.mta.se.lab.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import org.json.JSONArray;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;

import java.text.SimpleDateFormat;
import java.util.*;

import org.json.JSONObject;
import ro.mta.se.lab.model.Location;
import ro.mta.se.lab.model.Weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WeatherManager {

    @FXML private ComboBox country_list;
    @FXML private ComboBox city_list;

    @FXML private Label label_city;
    @FXML private Label label_datetime;
    @FXML private Label label_wather;
    @FXML private Label label_temp;
    @FXML private Label label_info_1;
    @FXML private Label label_info_2;
    @FXML private Label label_info_3;

    @FXML private ImageView image_wather;

    private Main main;

    private List<Location> Location_list;

    private Weather currentWeather;

    public void setMain(Main main) {
        this.main = main;

        init();
    }


    public void init()
    {
        read_inputFile();

        ObservableList<String> List_country = FXCollections.observableArrayList();

        for(Location loc:Location_list)
        {
            if(!List_country.contains(loc.getCountry()))
            {
                List_country.add(loc.getCountry());
            }
        }

        country_list.setItems(List_country);
    }

    public void read_inputFile()
    {
        Location_list =new ArrayList<Location>();

        try {
            File myObj = new File("src/main/resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                //System.out.println(data);

                String[] arrOfStr = data.split(" +");

                Location Lc = new Location(arrOfStr[4], arrOfStr[1], Double.parseDouble(arrOfStr[3]), Double.parseDouble(arrOfStr[2]));
                Location_list.add(Lc);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public String POSTS_API_URL = "";
    public String URL = "https://api.openweathermap.org/data/2.5/weather?";
    public String API_KEY =  "&appid=fc5e15137ffca57065dbb2e3e712bea4";

    public void http_req() throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());


        JSONObject obj = new JSONObject(response.body());

        currentWeather = new Weather();

        JSONObject obj2 = new JSONObject(obj.get("coord").toString());
        Double lon =  (Double)obj2.get("lon");
        Double lat =  (Double)obj2.get("lat");
        currentWeather.setLon(lon);
        currentWeather.setLat(lat);


        JSONArray ja = (JSONArray) obj.get("weather");
        JSONObject jsonobject = ja.getJSONObject(0);
        String type = (String)jsonobject.get("main");
        String desc = (String)jsonobject.get("description");
        currentWeather.setWeatherType(type);
        currentWeather.setWeatherDesc(desc);



        JSONObject obj3 = new JSONObject(obj.get("main").toString());

        Double temp =  (Double)obj3.get("temp");
        Double tMin =  (Double)obj3.get("temp_min");
        Double tMax =  (Double)obj3.get("temp_max");
        Integer press = (Integer)obj3.get("pressure");
        Integer humid = (Integer)obj3.get("humidity");
        currentWeather.setTemp(temp);
        currentWeather.setTempMin(tMin);
        currentWeather.setTempMax(tMax);
        currentWeather.setPress(press);
        currentWeather.setHumid(humid);


        Integer visib = (Integer)obj.get("visibility");
        currentWeather.setVisib(visib);


        JSONObject obj4 = new JSONObject(obj.get("wind").toString());

        String ws = obj4.get("speed").toString();
        Integer windspd;
        if(ws.contains("."))
        {
            Double dd = Double.parseDouble(ws);
            windspd = dd.intValue();

        }
        else
        {
            windspd = Integer.parseInt(ws);
        }


        currentWeather.setWindspd(windspd);

        currentWeather.setCountry(country_list.getValue().toString());
        currentWeather.setCity(city_list.getValue().toString());
    }

    public void set_view()
    {
        label_city.setText(currentWeather.getCity());
        label_wather.setText(currentWeather.getWeatherType() + " - " + currentWeather.getWeatherDesc());

        label_info_1.setText("Pressure: " + currentWeather.getPress() + "mb");
        label_info_2.setText("Humidity: " + currentWeather.getHumid() + "%");
        label_info_3.setText("Wind: " + currentWeather.getWindspd() + " km/h");

        Double tempC = currentWeather.getTemp() - 273.15;
        Integer aux = tempC.intValue();
        String bomb = new StringBuilder().appendCodePoint(0x00B0).toString();
        label_temp.setText(aux.toString() + bomb);



        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        label_datetime.setText(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));

        
    }
}

