package com.gridnine.testing.filter;

import org.junit.jupiter.api.Test;

import static com.gridnine.testing.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

class FlightFilterWithoutMoreThanTwoHoursGroundTimeTest {

    FlightFilter flightFilter = new FlightFilterWithoutMoreThanTwoHoursGroundTime();

    @Test
    void filter() {
        assertEquals(flightFilter.filter(ORIGIN), WITHOUT_MORE_THAN_TWO_HOURS_GROUND_TIME);
    }
}