package com.example.demo.service;

import com.example.demo.dto.locationDto.LocationDto;
import com.example.demo.dto.timingDto.Arrival;
import com.example.demo.dto.timingDto.Departure;
import com.example.demo.dto.timingDto.Timing;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimingCalculatorService {

    @Value("${here.api.key}")
    private String apiKey;
    RestTemplate restTemplate = new RestTemplate();

    public String calculateTravelTime(String locationFirst, String locationSecond) {

        String getLocationUrl = "https://router.hereapi.com/v8/routes?transportMode=car" +
                "&origin=" + getLocationLatLng(locationFirst) +
                "&destination=" + getLocationLatLng(locationSecond) +
                "&return=summary" +
                "&apikey=" + apiKey;

        String response = restTemplate.getForEntity(getLocationUrl, String.class).getBody();

        return getTime(response);
    }

    private String getTime(String response) {
        Timing targetObject = new Gson().fromJson(response, Timing.class);

        Arrival arrival = targetObject.getRoutes().get(0).getSections().get(0).getArrival();
        Departure departure = targetObject.getRoutes().get(0).getSections().get(0).getDeparture();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        Duration duration = Duration.between(
                LocalDateTime.parse(departure.getTime(), formatter),
                LocalDateTime.parse(arrival.getTime(), formatter));

        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return String.format("%d godzin i %d minut dojazdu", hours, minutes);
    }

    private String replaceSpaces(String string) {
        return string.replace(" ", "%20");
    }

    private String getLocationLatLng(String location) {
        String getLocationUrl = "https://geocode.search.hereapi.com/v1/geocode" +
                "?q=" +
                replaceSpaces(location) +
                "&apikey=" +
                apiKey;

        ResponseEntity<String> response
                = restTemplate.getForEntity(getLocationUrl, String.class);

        LocationDto targetObject = new Gson().fromJson(response.getBody(), LocationDto.class);

        return targetObject.getItems().get(0).getPosition().getLat() + "," + targetObject.getItems().get(0).getPosition().getLng();
    }
}
