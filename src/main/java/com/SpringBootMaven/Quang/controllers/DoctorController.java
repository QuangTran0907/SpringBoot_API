package com.SpringBootMaven.Quang.controllers;
import com.SpringBootMaven.Quang.models.*;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import com.SpringBootMaven.Quang.services.DoctorService;
import com.SpringBootMaven.Quang.services.DoctorService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class DoctorController {

    @Autowired
    private UserRepository userRepository;
    private final DoctorService docterService;

    public DoctorController(DoctorService doctorService) {
        this.docterService = doctorService;
    }



    @JsonView(Views.Custom.class)
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/top-doctor-home")
    ResponseEntity<Json_Response_User> getTopDoctorHome(@Param("limit")String limit)
    {
        limit = limit==null?"10":limit;
        List<User> users = userRepository.findAll();
        try {
            List<User> doctors = docterService.findUsersByRoleDataKeyMapLimited("R2",Integer.parseInt(limit));
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",doctors)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }


    @JsonView(Views.Custom.class)
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-all-doctor")
    ResponseEntity<Json_Response_User> getAllDoctors()
    {

        try {
            List<User> doctors = docterService.findUsersByRoleDataKey("R2");
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",doctors)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }

    @JsonView(Views.Custom.class)
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getdetailDoctor")
    ResponseEntity<Json_Response_User> getdetailDoctorSV(@Param("id")String id)
    {

        try {
            User doctor = userRepository.findById(Integer.parseInt(id)).orElse(new User());
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",doctor)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }



    @JsonView(Views.Custom.class)
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/post-infor-doctor")
    ResponseEntity<Json_Response_User> postinfordoctor(@RequestBody Json_Doctor_Request inputData)
    {

        try {
            String message = docterService.saveDetailDoctor(inputData);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",message)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }




    }

    @GetMapping("/get-schedule-doctor-by-date")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> getScheduleByDate(@Param("doctorid")String doctorid,@Param("date")String date)
    {

        try {
            if(doctorid==null||date==null) {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(1,"OK","Param is missing")

                        );
            }else {


                return docterService.getScheduleByDate(doctorid,date);
                        
            }
            

        }catch (Exception e)
        {
            System.out.println(e.toString());
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",null)

                    );
        }




    }

    @GetMapping("/get-extra-infor-doctor-by-id")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> getExtraInforDoctorById(@Param("idInput")String doctorid)
    {

        try {
            if(doctorid==null) {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(1,"OK","Param is missing")

                        );
            }else {


                return docterService.getExtraInforDoctorById(doctorid);

            }


        }catch (Exception e)
        {
            System.out.println(e.toString());
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",null)

                    );
        }




    }

    @JsonView(Views.Custom.class)
    @PostMapping("/bulk-create-schedule")
    ResponseEntity<Json_Response_User> bulkCreateSchedule(@Param("arrSchedule")List<Schedule> arrSchedule,@Param("doctorid") String doctorid,@Param("formatedDate") String formatedDate)
    {

        try {
            String message = docterService.bulkCreateSchedule(arrSchedule,formatedDate,doctorid);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",message)
                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }




    }
    @JsonView(Views.Custom.class)
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-profile-doctor-by-id")
    ResponseEntity<Json_Response_User> getProfileDoctorById(@Param("doctorid")String doctorid)
    {

        try {
            if(doctorid==null) {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(1,"OK","Param is missing")

                        );
            }else {


                return docterService.getProfileDoctorById(doctorid);

            }


        }catch (Exception e)
        {
            System.out.println(e.toString());
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response_User(1,"Parameter missing",null)

                    );
        }




    }












}
