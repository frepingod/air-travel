package com.gridnine.testing.filter;

import com.gridnine.testing.testdata.Flight;

import java.util.List;

public interface FlightFilter {

    List<Flight> filter(List<Flight> flights);
}