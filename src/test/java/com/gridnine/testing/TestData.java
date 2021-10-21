package com.gridnine.testing;

import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.Segment;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestData {

    private static final LocalDateTime THREE_DAYS_FROM_NOW = LocalDateTime.now().plusDays(3);

    //A normal single segment flight
    public static final Flight FLIGHT1 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2))
    ));
    //A normal multi segment flight
    public static final Flight FLIGHT2 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(5))
    ));
    //A flight departing in the past
    public static final Flight FLIGHT3 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW.minusDays(6), THREE_DAYS_FROM_NOW)
    ));
    //A single segment flight that departs before it arrives
    public static final Flight FLIGHT4 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.minusHours(6))
    ));
    //A multi segment flight, one segment of which departs before arrival
    public static final Flight FLIGHT5 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(4)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(5), THREE_DAYS_FROM_NOW.plusHours(3)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(4), THREE_DAYS_FROM_NOW.plusHours(7))
    ));
    //A flight with more than two hours ground time
    public static final Flight FLIGHT6 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(5), THREE_DAYS_FROM_NOW.plusHours(6))
    ));
    //Another flight with more than two hours ground time
    public static final Flight FLIGHT7 = new Flight(List.of(
            new Segment(THREE_DAYS_FROM_NOW, THREE_DAYS_FROM_NOW.plusHours(2)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(3), THREE_DAYS_FROM_NOW.plusHours(4)),
            new Segment(THREE_DAYS_FROM_NOW.plusHours(6), THREE_DAYS_FROM_NOW.plusHours(7))
    ));

    public static final List<Flight> ORIGIN = Arrays.asList(FLIGHT1, FLIGHT2, FLIGHT3, FLIGHT4, FLIGHT5, FLIGHT6, FLIGHT7);
    public static final List<Flight> WITHOUT_DEPARTURE_BEFORE_CURRENT = Arrays.asList(FLIGHT1, FLIGHT2, FLIGHT4, FLIGHT5, FLIGHT6, FLIGHT7);
    public static final List<Flight> WITHOUT_ARRIVAL_BEFORE_DEPARTURE = Arrays.asList(FLIGHT1, FLIGHT2, FLIGHT3, FLIGHT6, FLIGHT7);
    public static final List<Flight> WITHOUT_MORE_THAN_TWO_HOURS_GROUND_TIME = Arrays.asList(FLIGHT1, FLIGHT2, FLIGHT3, FLIGHT4, FLIGHT5);
}