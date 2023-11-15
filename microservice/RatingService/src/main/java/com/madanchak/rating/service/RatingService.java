package com.madanchak.rating.service;

import com.madanchak.rating.model.Rating;
import com.madanchak.rating.repository.RatingRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating){
        String rating3=UUID.randomUUID().toString();
        rating.setRatingId(rating3);
        return ratingRepository.save(rating);
    }
    public List<Rating> getAllRating(){
        return ratingRepository.findAll();
    }
    public List<Rating> getRatingByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }
    public List<Rating> getRatingByHotelId(String hotelId){
        return ratingRepository.findByHotelId(hotelId);
    }

}
