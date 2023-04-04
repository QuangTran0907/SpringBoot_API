package com.SpringBootMaven.Quang.repositories;

import com.SpringBootMaven.Quang.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    List<Schedule> findByDoctorDataIdAndDate(String doctorid, String date);
    Schedule findByTimeTypeDataKeyMapAndDateAndDoctorDataId(String typeTime,String date,String doctorId);
}
