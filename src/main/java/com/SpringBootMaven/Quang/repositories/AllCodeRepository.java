package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.AllCode;

import com.SpringBootMaven.Quang.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllCodeRepository extends JpaRepository<AllCode,Integer> {

    AllCode findByType(String type);

}
