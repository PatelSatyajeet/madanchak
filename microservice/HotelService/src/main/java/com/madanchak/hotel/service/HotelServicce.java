package com.madanchak.hotel.service;

import com.madanchak.hotel.model.Hotel;
import com.madanchak.hotel.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServicce {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel){
        String randomId1=UUID.randomUUID().toString();
        hotel.setId(randomId1);
        return hotelRepository.save(hotel);
    }
    public List<Hotel> getAllHotel(){
        return hotelRepository.findAll();
    }
    public Hotel getHotelById(String id){
        return hotelRepository.findById(id).orElse(null);
    }
}
