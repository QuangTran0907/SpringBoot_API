package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    Booking findByDocteridAndTockenAndStatusid(String doctorid,String token,String statusid);
}
