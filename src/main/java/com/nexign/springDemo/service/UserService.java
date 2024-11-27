package com.nexign.springDemo.service;

import com.nexign.springDemo.entities.UserEntity;
import com.nexign.springDemo.model.Address;
import com.nexign.springDemo.model.CityType;
import com.nexign.springDemo.model.User;
import com.nexign.springDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;
    private User user;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(User user) {
        UserEntity userEntity = new UserEntity(
                user.getAddress().getCity(),
                user.getAddress().getStreet(),
                CityType.LARGE);
        return userRepository.save(userEntity);
    }

    public User getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        Address address = new Address(userEntity.getCity(), userEntity.getStreet());
        return new User(address);
    }
}
