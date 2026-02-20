package com.example.busdemo1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.busdemo1.entity.Bus;
import com.example.busdemo1.service.BusService;



@RestController
@RequestMapping("/api/buses")
@CrossOrigin(origins = "http://localhost:8080")
public class BusController {
	
	@Autowired
    private BusService busService;

    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busService.addBus(bus);
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @GetMapping("/{id}")
    public Bus getBus(@PathVariable Long id) {
        return busService.getBusById(id);
    }

    @PutMapping("/{id}")
    public Bus updateBus(@PathVariable Long id,
                         @RequestBody Bus bus) {
        return busService.updateBus(id, bus);
    }

    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return "Bus deleted successfully";
    }

    @GetMapping("/search")
    public List<Bus> searchBus(@RequestParam String from,
                               @RequestParam String to,
                               @RequestParam String date) {
        return busService.searchBus(from, to, date);
    }


}
