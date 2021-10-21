package com.gridnine.testing.filter;

import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.Segment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterWithoutMoreThanTwoHoursGroundTime implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        final List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            final List<Segment> segments = flight.getSegments();
            long groundTime = 0;

            for (int i = 0; i < segments.size() - 1; i++) {
                groundTime += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toMinutes();
                if (groundTime > 120) {
                    break;
                }
            }

            if (groundTime <= 120) {
                result.add(flight);
            }
        }
        return result;
    }
}