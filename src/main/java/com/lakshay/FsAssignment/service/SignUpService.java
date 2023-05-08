package com.lakshay.FsAssignment.service;

import com.lakshay.FsAssignment.entity.User;
import com.lakshay.FsAssignment.model.HomeRequest;
import com.lakshay.FsAssignment.model.HomeResponse;
import com.lakshay.FsAssignment.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Log4j2
public class SignUpService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<HomeResponse> signUpService(HomeRequest request, HttpServletRequest servletRequest) {
        List<String> usernames = repository.getUserNames();
        if (usernames.contains(request.getUsername())) {
            log.info("User " + request.getUsername() + " is already saved");
            return new ResponseEntity<>(HomeResponse.builder().message("This username is already used.").build(), HttpStatus.NOT_ACCEPTABLE);
        }
        repository.save(User.builder().username(request.getUsername()).password(request.getPassword().hashCode()).build());
        log.info("New user " + request.getUsername() + " is saved");
        return new ResponseEntity<>(HomeResponse.builder().message("Your user has been created. You can now login.").build(), HttpStatus.ACCEPTED);
    }
}
