package com.gridnine.testing.filter;

import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.Segment;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightFilterWithoutMoreThanTwoHoursGroundTime implements FlightFilter {

    private static final int GROUND_TIME_TO_MINUTES = 120;

    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> getGroundTime(flight.getSegments()) <= GROUND_TIME_TO_MINUTES)
                .collect(Collectors.toList());
    }

    private int getGroundTime(List<Segment> segments) {
        return IntStream.range(0, segments.size() - 1)
                .map(i -> (int) Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toMinutes())
                .sum();
    }
}