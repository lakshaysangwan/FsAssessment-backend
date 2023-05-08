package com.lakshay.FsAssignment.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDetailsRequest {
    private String username;
    private String name;
    private String email;
    private String phoneNumber;
}
