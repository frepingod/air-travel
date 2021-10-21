package com.gridnine.testing.filter;

import org.junit.jupiter.api.Test;

import static com.gridnine.testing.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightFilterWithoutArrivalBeforeDepartureTest {

    FlightFilter flightFilter = new FlightFilterWithoutArrivalBeforeDeparture();

    @Test
    void filter() {
        assertEquals(flightFilter.filter(ORIGIN), WITHOUT_ARRIVAL_BEFORE_DEPARTURE);
    }
}