package com.example.ThymleafStart.Model;

import com.example.ThymleafStart.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String FirstName) throws UsernameNotFoundException {
      User user = userRepository.getUserByUsername(FirstName);
         if(user==null)
            throw new UsernameNotFoundException("User 404");
      return new MyUserDetails(user);

    }
}