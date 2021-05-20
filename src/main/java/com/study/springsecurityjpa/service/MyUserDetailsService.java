package com.study.springsecurityjpa.service;

import com.study.springsecurityjpa.model.MyUserDetails;
import com.study.springsecurityjpa.model.User;
import com.study.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(s);
        //return new MyUserDetails(user.get());
        user.orElseThrow(() -> new UsernameNotFoundException("Not Found : " + s));
        return user.map(MyUserDetails::new).get();
    }
}
