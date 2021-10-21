package com.gridnine.testing.filter;

import org.junit.jupiter.api.Test;

import static com.gridnine.testing.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterWithoutDepartureBeforeCurrentTest {

    FlightFilter flightFilter = new FlightFilterWithoutDepartureBeforeCurrent();

    @Test
    void filter() {
        assertEquals(flightFilter.filter(ORIGIN), WITHOUT_DEPARTURE_BEFORE_CURRENT);
    }
}