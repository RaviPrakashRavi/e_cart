package com.ravi.major.service;

import com.ravi.major.dto.requestentity.CustomerUpdateRequest;
import com.ravi.major.exception.UserException;
import com.ravi.major.mappers.CustomerMapper;
import com.ravi.major.model.User;
import com.ravi.major.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerMapper customerMapper;
    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUserById(int id) {

        userRepository.deleteById(id);
    }


    public List<User> getAllUsers() {

        return userRepository.findAll();
    }


    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            throw new UserException("user not found");
        }
        return user.get();
    }

    public void updateUser(User user) {

        userRepository.save(user);
    }


    public void updateCustomer(CustomerUpdateRequest customerUpdateRequest, int userId) {
        User user = customerMapper.customerUpdateRequestToUser(customerUpdateRequest,userId);
       updateUser(user);
    }
}
