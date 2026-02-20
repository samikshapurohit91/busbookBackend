package com.example.busdemo1.service;

import java.util.List;

import com.example.busdemo1.entity.Bus;



public interface BusService {
	
	
	Bus addBus(Bus bus);

    List<Bus> getAllBuses();

    Bus getBusById(Long id);

    Bus updateBus(Long id, Bus bus);

    void deleteBus(Long id);

    List<Bus> searchBus(String from, String to, String date);

}
