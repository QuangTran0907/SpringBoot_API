package com.SpringBootMaven.Quang.controllers;
import com.SpringBootMaven.Quang.models.Json_Response;
import com.SpringBootMaven.Quang.models.User;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class DoctorController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/top-doctor-home")
    ResponseEntity<Json_Response> getTopDoctorHome(@Param("limit")String limit)
    {
        limit = limit==null?"10":limit;
        try {
            List<User> doctors = userRepository.findAll();
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(0,"OK",doctors)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response(1,"Parameter missing",null)
                    );
        }

    }
}
