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

@Service
@Log4j2
public class LoginService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<HomeResponse> loginService(HomeRequest request, HttpServletRequest servletRequest) {

        User user = repository.getUserByUsername(request.getUsername());
        if (user == null) {
            return new ResponseEntity<>(HomeResponse.builder().message("This user doesn't exist.").build(), HttpStatus.ACCEPTED);
        } else if (user.getPassword() == request.getPassword().hashCode()) {
            return new ResponseEntity<>(HomeResponse.builder().message("You've logged in.").build(), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HomeResponse.builder().message("Wrong password. Please try again.").build(), HttpStatus.NOT_ACCEPTABLE);
    }
}
