package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;

@Component
public class OnTimeRequester {

    @Value("${here.start}")
    String startPoint;
    @Value("${here.destination}")
    String destinationPoint;

    TimingCalculatorService timingCalculatorService;

    private static final Map<String, String> timing = new HashMap<>();

    public static Map<String, String> getTiming() {
        return timing;
    }

    public OnTimeRequester(TimingCalculatorService timingCalculatorService) {
        this.timingCalculatorService = timingCalculatorService;
    }

    @Scheduled(fixedRateString = "${hourly.schedule.interval}")
    public void hourlyTask() {
        String formattedDateTime = getDate() + " "+getTime() ;

        String travelTime = timingCalculatorService.calculateTravelTime(startPoint, destinationPoint);
        timing.put(formattedDateTime, travelTime);
        updateFile(formattedDateTime, travelTime);

        System.out.println("Current date and time: " + formattedDateTime + " - " + travelTime);
    }

    private String getDate() {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDate.now());
    }

    private String getTime() {
        return  DateTimeFormatter.ofPattern( "HH:mm:ss").format(LocalTime.now());
    }

    private void updateFile(String formattedDateTime, String travelTime) {
        String filePath = "travel_times.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(formattedDateTime + " - " + travelTime);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
