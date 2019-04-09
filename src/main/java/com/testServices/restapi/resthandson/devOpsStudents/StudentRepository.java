package com.testServices.restapi.resthandson.devOpsStudents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<DevOpsStudents, Integer>{

}
