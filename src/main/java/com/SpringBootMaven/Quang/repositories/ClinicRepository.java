package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic,Integer> {

}
