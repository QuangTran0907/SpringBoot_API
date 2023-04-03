package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Markdown;
import com.SpringBootMaven.Quang.models.Product;
import com.SpringBootMaven.Quang.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkDownRePository extends JpaRepository<Markdown,Integer> {

    Markdown findByDoctorId(String doctorid);}
