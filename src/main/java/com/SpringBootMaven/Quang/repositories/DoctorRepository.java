package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Doctor_Infor;
import com.SpringBootMaven.Quang.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository  extends JpaRepository<Doctor_Infor,Integer> {


}