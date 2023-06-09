package com.lakshay.FsAssignment.repository;

import com.lakshay.FsAssignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "Select username from user", nativeQuery = true)
    List<String> getUserNames();

    User getUserByUsername(String username);
}
