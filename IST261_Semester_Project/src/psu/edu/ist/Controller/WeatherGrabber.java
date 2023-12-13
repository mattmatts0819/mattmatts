package psu.edu.ist.Controller;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherGrabber {
    private static final String API_KEY = "92984b0ac746afbd0607866a894ea05a";  // Replace with your actual API key
    private String city;
    public WeatherGrabber(String city) {
        this.city = city;  // Replace with the desired city name

    }
    public double getWeather(){
        try {
            // Create a URL for the API call
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY);

            // Establish the connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }

            // Close the BufferedReader
            in.close();

            // Parse the JSON response to get the temperature
            JSONObject jsonResponse = new JSONObject(responseContent.toString());
            JSONObject main = jsonResponse.getJSONObject("main");
            double temperatureKelvin = main.getDouble("temp");
            double temperatureF = ((temperatureKelvin - 273.15) * 1.8) + 32;

            // Print the current temperature
            return (int) temperatureF;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

