package com.example.demo;

import com.example.demo.dto.locationDto.LocationDto;
import com.example.demo.dto.timingDto.Arrival;
import com.example.demo.dto.timingDto.Departure;
import com.example.demo.dto.timingDto.Timing;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        String json = "{\"routes\":[{\"id\":\"9ce4b0d1-d341-4357-ac7b-c1bccbcb3389\",\"sections\":[{\"id\":\"6bdef460-743f-4c7d-88c1-620a0bfe8ac2\",\"type\":\"vehicle\"," +
                "\"departure\":{\"time\":\"2023-03-21T19:35:19+01:00\",\"place\":{\"type\":\"place\",\"location\":{\"lat\":52.5309838,\"lng\":13.3845671}," +
                "\"originalLocation\":{\"lat\":52.5307999,\"lng\":13.3847}}},\"arrival\":{\"time\":\"2023-03-21T19:37:15+01:00\",\"place\":{\"type\":\"place\"," +
                "\"location\":{\"lat\":52.5323264,\"lng\":13.378874},\"originalLocation\":{\"lat\":52.5323,\"lng\":13.3789}}},\"summary\":{\"duration\":116," +
                "\"length\":538,\"baseDuration\":92},\"transport\":{\"mode\":\"car\"}}]}]}";

        Timing targetObject = new Gson().fromJson(json, Timing.class);

        Arrival arrival = targetObject.getRoutes().get(0).getSections().get(0).getArrival();
        Departure departure = targetObject.getRoutes().get(0).getSections().get(0).getDeparture();

        DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        LocalDateTime dateTime1 = LocalDateTime.parse(arrival.getTime(), formatter);
        System.out.println(dateTime1);
        LocalDateTime dateTime2 = LocalDateTime.parse(departure.getTime(), formatter);
        System.out.println(dateTime2);


        Duration duration = Duration.between(dateTime2, dateTime1);
        System.out.println("Różnica czasu w sekundach: " + duration);
    }

    @Test
    void test2() {
        String json = "{\"items\":[{\"title\":\"Katowice, Woj. Śląskie, Polska\",\"id\":\"here:cm:namedplace:20629029\",\"resultType\":\"locality\"," +
                "\"localityType\":\"city\",\"address\":{\"label\":\"Katowice, Woj. Śląskie, Polska\",\"countryCode\":\"POL\",\"countryName\":\"Polska\"," +
                "\"state\":\"Woj. Śląskie\",\"county\":\"Katowice\",\"city\":\"Katowice\",\"postalCode\":\"40-022\"},\"position\":{\"lat\":50.25636,\"lng\":19.03103}," +
                "\"mapView\":{\"west\":18.8913,\"south\":50.12894,\"east\":19.12226,\"north\":50.29767},\"scoring\":{\"queryScore\":1.0,\"fieldScore\":{\"city\":1.0}}}]}";

        LocationDto targetObject = new Gson().fromJson(json, LocationDto.class);

        System.out.println(targetObject.toString());
    }

    @Test
    void daytest() {
        System.out.println(getDate() + " "+ getTime());
    }


    @Test
    void fullDate(){
        LocalDate anotherSummerDay = LocalDate.now();
        LocalTime anotherTime = LocalTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(anotherSummerDay, anotherTime, ZoneId.of("Europe/Helsinki"));
        System.out.println(zonedDateTime);
        System.out.println( DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(zonedDateTime) + " "+ getTime());

    }

    private String getDate() {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now());
    }

    private String getTime() {
       return  DateTimeFormatter.ofPattern( "HH:mm:ss").format(LocalTime.now());
    }
}
