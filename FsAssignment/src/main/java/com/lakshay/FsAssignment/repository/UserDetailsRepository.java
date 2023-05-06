package com.lakshay.FsAssignment.repository;

import com.lakshay.FsAssignment.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    UserDetails findByUsername(String username);
}
