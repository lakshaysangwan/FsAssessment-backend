package com.lakshay.FsAssignment.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class HomeRequest {
    private String username;
    private String password;
}
