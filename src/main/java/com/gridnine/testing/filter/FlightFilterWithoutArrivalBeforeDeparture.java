package com.gridnine.testing.filter;

import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.Segment;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterWithoutArrivalBeforeDeparture implements FlightFilter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        final List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            final List<Segment> segments = flight.getSegments();
            boolean isSuitable = segments.stream()
                    .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()));

            if (isSuitable) {
                result.add(flight);
            }
        }
        return result;
    }
}