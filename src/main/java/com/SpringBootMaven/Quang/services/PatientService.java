package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.AllCode;
import com.SpringBootMaven.Quang.models.Booking;
import com.SpringBootMaven.Quang.models.Response.JsonEmail;
import com.SpringBootMaven.Quang.models.Response.Json_Patient_Request;
import com.SpringBootMaven.Quang.models.User;
import com.SpringBootMaven.Quang.repositories.AllCodeRepository;
import com.SpringBootMaven.Quang.repositories.BookingRepository;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public class PatientService {
    @Autowired
    AllCodeRepository allCodeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    private EmailService emailService;
    String buildUrlEmail (String doctorid,String token)
    {
        return "http://localhost:3000/verify-booking?token="+token+"&doctorid="+doctorid+"}";
    }
    public String postBookAppointment(Json_Patient_Request jsonPatientRequest){

        if(jsonPatientRequest.getEmail()==null||jsonPatientRequest.getDoctorName()==null||jsonPatientRequest.getTime()==null||jsonPatientRequest.getFullName()==null)
        {
            return "param is missing";
        }
        else {

            UUID token = UUID.randomUUID();
            String link = buildUrlEmail(jsonPatientRequest.getDoctorid(),token.toString());


            JsonEmail jsonEmail = new JsonEmail(jsonPatientRequest.getLanguage(),jsonPatientRequest.getFullName(),jsonPatientRequest.getTime(),jsonPatientRequest.getDoctorName(),link, jsonPatientRequest.getEmail());
            User newUser = new User();
            newUser.setEmail(jsonPatientRequest.getEmail());
            newUser.setRoleData(allCodeRepository.findByKeyMap("R3"));
            newUser.setGenderData(allCodeRepository.findByKeyMap(jsonPatientRequest.getSelectedGender()));
            newUser.setAddress(jsonPatientRequest.getAddress());
            newUser.setFirstName(jsonPatientRequest.getFullName());

            userRepository.save(newUser);

            Booking booking = new Booking();
            booking.setStatusId("s1");
            booking.setDoctorId(Integer.parseInt(jsonPatientRequest.getDoctorid()));
            booking.setPatientId(newUser.getId());
            booking.setDate(jsonPatientRequest.getDate());
            booking.setTimeType(jsonPatientRequest.getTimeType());
            booking.setToken(token.toString());

            return "Save infor patient succed!";

        }
    }
    public String postVerifyBookAppointment(Json_Patient_Request jsonPatientRequest)
    {
        if(jsonPatientRequest.getToken()==null||jsonPatientRequest.getDoctorid()==null)
        {
            return "Missing parameter";
        }
        else {
         Booking appointment = bookingRepository.findByDoctorIdAndTokenAndStatusId(jsonPatientRequest.getDoctorid(),jsonPatientRequest.getToken(),"S1");
        if(appointment!=null){
            appointment.setStatusId("S2");
            bookingRepository.save(appointment);
            return "Update the appointment succeed!";
        }else {
            return "Appointment has been activated or does not exist";
        }

        }
    }

}
