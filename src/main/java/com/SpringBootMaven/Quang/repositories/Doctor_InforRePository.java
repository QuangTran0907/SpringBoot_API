package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Doctor_Infor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Doctor_InforRePository extends JpaRepository<Doctor_Infor,Integer> {
    Doctor_Infor findByUserId(int doctorid );
}

