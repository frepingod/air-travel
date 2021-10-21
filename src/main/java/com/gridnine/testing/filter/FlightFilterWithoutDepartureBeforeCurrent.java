package com.gridnine.testing.filter;

import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterWithoutDepartureBeforeCurrent implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        final List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            final Segment segment = flight.getSegments().get(0);
            if (!segment.getDepartureDate().isBefore(LocalDateTime.now())) {
                result.add(flight);
            }
        }
        return result;
    }
}