package com.lakshay.FsAssignment.repository;

import com.lakshay.FsAssignment.entity.CheckCalls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckCallsRepository extends JpaRepository<CheckCalls, Long> {
}
