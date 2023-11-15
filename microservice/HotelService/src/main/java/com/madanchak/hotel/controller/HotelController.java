package com.madanchak.hotel.controller;

import com.madanchak.hotel.model.Hotel;
import com.madanchak.hotel.service.HotelServicce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelServicce hotelServicce;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        Hotel hotel2=hotelServicce.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel2);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> findAllHotel(){
        List<Hotel> allHotel=hotelServicce.getAllHotel();
        return ResponseEntity.ok(allHotel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> findHotelById(@PathVariable String id){
        Hotel hotel=hotelServicce.getHotelById(id);
        return ResponseEntity.ok(hotel);
    }
}
