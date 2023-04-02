package com.SpringBootMaven.Quang.controllers;
import com.SpringBootMaven.Quang.models.Json_Response;
import com.SpringBootMaven.Quang.models.Json_Response_User;
import com.SpringBootMaven.Quang.models.User;
import com.SpringBootMaven.Quang.models.Views;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import com.SpringBootMaven.Quang.services.DoctorService;
import com.SpringBootMaven.Quang.services.DoctorService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/post-infor-doctor")
    ResponseEntity<Json_Response_User> postinfordoctor()
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



}
