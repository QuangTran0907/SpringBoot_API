package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    Booking findByDoctorIdAndTokenAndStatusId(String doctorid,String token,String statusid);
}
