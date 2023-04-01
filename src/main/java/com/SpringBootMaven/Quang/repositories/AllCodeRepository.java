package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.AllCode;

import com.SpringBootMaven.Quang.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllCodeRepository extends JpaRepository<AllCode,Integer> {

    List<AllCode> findByType(String type);

}
