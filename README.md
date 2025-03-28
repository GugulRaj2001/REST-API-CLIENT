#  🏷️ REST API CLIENT

*COMPANY* : CODTECH IT SOLUTIONS

*NAME*    : RAJKUMAR GUGULOTH

*INTERN ID* : CT06WC118

*DOMAIN*  : JAVA PROGRAMMING

*DURATION* : 6 WEEKS

*MENTOR*  : NEELA SANTHOSH KUMAR

# 📋 TASK DESCRIPTION:
*Overview of the Task* :

As part of my internship, I was assigned the task of developing a Java-based Weather API client that fetches real-time weather data using the OpenWeatherMap API. The goal of this task was to create a simple yet efficient Java program that takes a city name and unit type (Celsius, Fahrenheit, or Kelvin) as input and retrieves temperature, humidity, and weather conditions, displaying the results in a structured format.

The program follows a structured approach by implementing HTTP requests using Java’s HttpURLConnection and parsing JSON responses with the Jackson library. This ensures that the program efficiently communicates with the API, processes the response, and presents the weather details in a readable and well-organized format.

By working on this task, I have gained hands-on experience in REST API integration, JSON parsing, and Java I/O operations. Additionally, I have enhanced my understanding of error handling techniques by implementing checks for invalid city names, API failures, and missing inputs. This project has helped me strengthen my knowledge of Java networking and real-world API consumption in software development.

# 🛠️🖥️ Tools and Technologies Used:
✅ Programming Language: Java

✅ Frameworks & Libraries:

       ➤ Jackson (com.fasterxml.jackson.databind) – for parsing JSON responses

       ➤ Java Networking (java.net.HttpURLConnection, java.net.URL) – for making API requests

       ➤ Java I/O (BufferedReader, InputStreamReader) – for handling API responses

✅ API Used: OpenWeatherMap API

# 💡 Features:
✔️ City Input: The user can input any city name to get the weather report.

✔️ Unit Selection: Users can choose the temperature unit:

       👉🏾 Metric (Celsius)

       👉🏾 Imperial (Fahrenheit)

       👉🏾 Standard (Kelvin)
           
✔️ Weather Data Retrieval: The program fetches data from the OpenWeatherMap API using an HTTP GET request.

✔️ Error Handling:

      👉🏾 Invalid city name (Displays error message)
      
✔️ JSON Parsing: The response is parsed using the Jackson library to extract weather data like temperature, humidity, and weather condition.

✔️ Formatted Output: Weather data (especially temperature) is formatted and displayed with 2 decimal places.

# Task Execution:
### 1.*User Input (City and Temperature Unit):*

 ==> The user is asked to input a city name and a unit type (metric, imperial, or standard).

### 2.*API Request:*

 ==> Using the provided inputs, the program constructs the API URL and sends a request to fetch weather data.

### 3.*Response Handling:*

==> The program checks the HTTP response code to ensure it's successful (HTTP 200).

### 4.*JSON Parsing:*

 ==> After confirming the success, the JSON response is parsed, extracting relevant data like temperature, humidity, and description.

### 5.*Output Display:*

 ==> The program then displays the formatted weather report with details like the temperature, humidity, and weather condition.



## 🚀 Which Editor Used:         *Eclipse*


# O/P OF PROGRAM:

### For example, if the user enters city = "Kerala" and unit = "metric", the output could look like this:

Enter the city name: kerala

Enter the unit (metric, imperial, standard): 

No unit provided. Defaulting to 'metric' (Celsius).

*************************************

🌟🌟🌟 Weather Report 📈📈📈 

*************************************

City: Kerala

Temperature: 34.98°C

Humidity: 45%

Condition: scattered clouds

*************************************

### If the API call fails or the response is empty, the program will display:

==> ***Error:*** Empty response from the weather service.







