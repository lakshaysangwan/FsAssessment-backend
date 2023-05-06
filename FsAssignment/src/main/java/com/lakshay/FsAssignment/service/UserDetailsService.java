package com.lakshay.FsAssignment.service;

import com.lakshay.FsAssignment.entity.UserDetails;
import com.lakshay.FsAssignment.model.HomeResponse;
import com.lakshay.FsAssignment.model.UserDetailsRequest;
import com.lakshay.FsAssignment.repository.UserDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserDetailsService {
    @Autowired
    private UserDetailsRepository repository;

    public ResponseEntity<HomeResponse> saveUser(UserDetailsRequest request) {
        log.info("save ho gya bhai");
        UserDetails details = UserDetails.builder().username(request.getUsername()).email(request.getEmail()).name(request.getName()).phoneNumber(request.getPhoneNumber()).build();
        repository.save(details);
        return new ResponseEntity<>(HomeResponse.builder().message("User details saved.").build(), HttpStatus.ACCEPTED);
    }

    public ResponseEntity<UserDetails> getUser(String username) {
        UserDetails details = repository.findByUsername(username);
        if (details == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(details, HttpStatus.ACCEPTED);
        }
    }
}
