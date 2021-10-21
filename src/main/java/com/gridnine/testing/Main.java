package com.gridnine.testing;

import com.gridnine.testing.filter.FlightFilter;
import com.gridnine.testing.filter.FlightFilterWithoutArrivalBeforeDeparture;
import com.gridnine.testing.filter.FlightFilterWithoutDepartureBeforeCurrent;
import com.gridnine.testing.filter.FlightFilterWithoutMoreThanTwoHoursGroundTime;
import com.gridnine.testing.testdata.Flight;
import com.gridnine.testing.testdata.FlightBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Список полетов до фильтраций:");
        System.out.println(flights);

        FlightFilter filter1 = new FlightFilterWithoutDepartureBeforeCurrent();
        FlightFilter filter2 = new FlightFilterWithoutArrivalBeforeDeparture();
        FlightFilter filter3 = new FlightFilterWithoutMoreThanTwoHoursGroundTime();

        System.out.println("\nСписок полетов без вылетов до текущего момента времени:");
        System.out.println(filter1.filter(flights));

        System.out.println("\nСписок полетов без полетов с сегментами, у которых дата прилёта раньше даты вылета:");
        System.out.println(filter2.filter(flights));

        System.out.println("\nСписок полетов с общим временем на земле менее двух часов:");
        System.out.println(filter3.filter(flights));
    }
}