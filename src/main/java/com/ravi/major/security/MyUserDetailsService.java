package com.ravi.major.security;

import com.ravi.major.model.User;
import com.ravi.major.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private User user;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        user = userRepository.findByUserName(userName);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("user not found");
        }
        return new MyUserDetails(user);
    }
}
