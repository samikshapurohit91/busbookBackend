package com.example.busdemo1.servicee.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.busdemo1.Repository.BusRepository;
import com.example.busdemo1.entity.Bus;
import com.example.busdemo1.service.BusService;


@Service
public class BusServiceImpl implements BusService{
	
	@Autowired
    private BusRepository busRepository;

    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found"));
    }

    @Override
    public Bus updateBus(Long id, Bus updatedBus) {

        Bus bus = getBusById(id);

        bus.setName(updatedBus.getName());
        bus.setOperator(updatedBus.getOperator());
        bus.setFrom(updatedBus.getFrom());
        bus.setTo(updatedBus.getTo());
        bus.setDepartureTime(updatedBus.getDepartureTime());
        bus.setArrivalTime(updatedBus.getArrivalTime());
        bus.setDuration(updatedBus.getDuration());
        bus.setPrice(updatedBus.getPrice());
        bus.setTotalSeats(updatedBus.getTotalSeats());
        bus.setAvailableSeats(updatedBus.getAvailableSeats());
        bus.setAmenities(updatedBus.getAmenities());
        bus.setRating(updatedBus.getRating());
        bus.setBusType(updatedBus.getBusType());
        bus.setDate(updatedBus.getDate());

        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    public List<Bus> searchBus(String from, String to, String date) {
        return busRepository.findByFromAndToAndDate(from, to, date);
    }
}


