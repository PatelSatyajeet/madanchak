package com.madanchak.user_service.service;

import com.madanchak.user_service.Repository.UserRepository;
import com.madanchak.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(String userId){
        return userRepository.findById(userId).orElse(null);
    }
    public String deleteUserById(String userId){
        userRepository.deleteById(userId);
        return "Deleted UserId "+userId;
    }
    public User updateUserById(User user){
        User exist=userRepository.findById(user.getUserId()).orElse(null);
        exist.setName(user.getName());
        exist.setEmail(user.getEmail());
        exist.setAbout(user.getAbout());
        return userRepository.save(user);
    }
    public User patchUserById(User user){
        User exist=userRepository.findById(user.getUserId()).orElse(null);
        if(exist !=null){
            if(user.getName()!=null){
                exist.setName(user.getName());
            }
            if(user.getEmail()!=null){
                exist.setEmail(user.getEmail());
            }
            if(user.getAbout()!=null){
                exist.setAbout(user.getAbout());
            }
            return userRepository.save(exist);
        }
        return null;
    }
}
