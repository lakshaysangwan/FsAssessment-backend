package com.lakshay.FsAssignment.controller;

import com.lakshay.FsAssignment.entity.UserDetails;
import com.lakshay.FsAssignment.model.HomeRequest;
import com.lakshay.FsAssignment.model.HomeResponse;
import com.lakshay.FsAssignment.model.UserDetailsRequest;
import com.lakshay.FsAssignment.service.LoginService;
import com.lakshay.FsAssignment.service.SignUpService;
import com.lakshay.FsAssignment.service.UserDetailsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
@Log4j2
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class HomeController {

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserDetailsService detailsService;

    @PostMapping(value = "/signup")
    public ResponseEntity<HomeResponse> signUp(@RequestBody HomeRequest homeRequest, HttpServletRequest request) {
        return signUpService.signUpService(homeRequest, request);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<HomeResponse> logIn(@RequestBody HomeRequest homeRequest, HttpServletRequest request) {
        return loginService.loginService(homeRequest, request);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HomeResponse> saveUserDetails(@RequestBody UserDetailsRequest detailsRequest, HttpServletRequest request) {
        return detailsService.saveUser(detailsRequest);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable String username, HttpServletRequest request) {
        return detailsService.getUser(username);
    }
}

