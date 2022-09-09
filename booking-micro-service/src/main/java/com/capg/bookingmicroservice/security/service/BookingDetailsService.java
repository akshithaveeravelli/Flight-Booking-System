package com.capg.bookingmicroservice.security.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capg.bookingmicroservice.entity.BookingDetails;
import com.capg.bookingmicroservice.repository.BookingRepository;

@Service
public class BookingDetailsService implements UserDetailsService{
	
	@Autowired
    private BookingRepository bookingRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;
        Optional<BookingDetails> bookingDetails = bookingRepository.getUserDataByUsername(userName);

        if (bookingDetails == null) {
            throw new UsernameNotFoundException(userName);
        }
        else {
            if (userName.equals("admin")) {
                roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new User("admin", "admin", roles);
            }
            else {
                String username = bookingDetails.get().getUsername();
                String password = bookingDetails.get().getUserPassword();
                roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                return new User(username, password, roles);
            }
        }
    }
	
	

}
