package RestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherAPI {

	// Replace with your OpenWeatherMap API key Other wise you getting 401 error
    private static final String API_KEY = "d18c49f2fee14f9947def34721e93dbb";
  
 // API URL with placeholders for city, API key, and unit
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=%s";
     

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take city input from the user
        
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();

        // Take unit type input (metric, imperial, or standard)
        
        System.out.print("Enter the unit (metric, imperial, standard): ");
        String unit = scanner.nextLine().trim();

        // If no unit is provided, default to metric (Celsius)
        
        if (unit.isEmpty()) {
        	
        	// Default to metric (Celsius)
        	
            unit = "metric";  
            System.out.println("No unit provided. Defaulting to 'metric' (Celsius).");
        }

        String urlString = String.format(API_URL, city, API_KEY, unit);

        try {
            // Fetch weather data
        	
            String response = sendGetRequest(urlString);

            // Check if response is empty or null
            
            if (response == null || response.isEmpty()) {
                System.out.println("Error: Empty response from the weather service.");
                return;
            }

            // Parse and display weather data
            
            parseWeatherData(response, unit);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to send HTTP GET request
    
    private static String sendGetRequest(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Checking if response code is 200 (OK)
        
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Failed to fetch data. HTTP Response Code: " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    // Method to parse and display weather data from the JSON response
    
    private static void parseWeatherData(String jsonResponse, String unit) {
        try {
            // Initialize ObjectMapper for JSON parsing
        	
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse the JSON response
            
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Check if there is an error message in the JSON response (e.g., city not found)
            
            if (rootNode.has("message")) {
                System.out.println("Error: " + rootNode.path("message").asText());
                return;
            }

            JsonNode mainNode = rootNode.path("main");
            JsonNode weatherNode = rootNode.path("weather").get(0);

            // Extract specific data
            
            String cityName = rootNode.path("name").asText();
            // Temperature from API
            double temperature = mainNode.path("temp").asDouble();  
            int humidity = mainNode.path("humidity").asInt();
            String weatherDescription = weatherNode.path("description").asText();

            // Convert the temperature based on the selected unit
            
            double finalTemperature = temperature;
            String temperatureUnit = "°C";  // Default to Celsius

            if (unit.equalsIgnoreCase("imperial")) 
            {
            	
                // For imperial units (Fahrenheit), convert Celsius to Fahrenheit
                finalTemperature = (temperature * 9 / 5) + 32;
                temperatureUnit = "°F";
            } else if (unit.equalsIgnoreCase("standard")) {
            	
                // For standard unit (Kelvin), convert Kelvin to Celsius
                finalTemperature = temperature - 273.15; // Convert from Kelvin to Celsius
                temperatureUnit = "°C";  // Still display in Celsius
            } else if (unit.equalsIgnoreCase("metric")) {
            	
                // Metric unit returns temperature in Celsius directly
                finalTemperature = temperature;
                temperatureUnit = "°C";
            }

            // **Ensure temperature is formatted with exactly 2 decimal places**
            System.out.println("*************************************");
            System.out.println("🌟🌟🌟 Weather Report 📈📈📈 ");
            System.out.println("*************************************");
            System.out.println("City: " + cityName);
            System.out.println("Temperature: " + String.format("%.2f", finalTemperature) + temperatureUnit); // **Formatted with 2 decimal places**
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Condition: " + weatherDescription);
            System.out.println("*************************************");

        } catch (Exception e) {
            System.out.println("Error parsing JSON response: " + e.getMessage());
        }
    }
}
