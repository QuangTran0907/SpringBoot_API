package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Clinic;
import com.SpringBootMaven.Quang.models.Json_Response_User;
import com.SpringBootMaven.Quang.models.Response.Json_Patient_Request;
import com.SpringBootMaven.Quang.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/patient-book-appointment")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> postBookAppointment(@RequestBody Json_Patient_Request jsonPatientRequest)
    {


        try {
            String result = patientService.postBookAppointment(jsonPatientRequest);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",result)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }

    @PostMapping("/verify-book-appointment")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> postVerifyBookAppointment(@RequestBody Json_Patient_Request jsonPatientRequest)
    {


        try {
            String result = patientService.postBookAppointment(jsonPatientRequest);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",result)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }


}
