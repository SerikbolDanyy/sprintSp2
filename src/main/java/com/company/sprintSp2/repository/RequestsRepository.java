package com.company.sprintSp2.repository;

import com.company.sprintSp2.entities.ApplicationRequest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RequestsRepository extends JpaRepository<ApplicationRequest, Long> {

}
