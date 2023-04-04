package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Clinic;
import com.SpringBootMaven.Quang.models.Json_Response_User;
import com.SpringBootMaven.Quang.repositories.ClinicRepository;
import com.SpringBootMaven.Quang.services.ClinicService;
import com.SpringBootMaven.Quang.services.DoctorService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping("/create-new-clinic")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> createClinic(@RequestBody Clinic clinic)
    {

        try {
               String result =  clinicService.createClinic(clinic);


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

    @GetMapping("/get-clinic")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> getAllClinic()
    {

        try {
            List<Clinic> allClinic = clinicService.allClinic();
            if (allClinic.size()>0)
            {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK",allClinic)

                        );
            }
            else {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK","clinic is empty!")

                        );
            }




        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }

    @GetMapping("/get-detail-clinic-by-id")
    @CrossOrigin(origins = "http://localhost:3000")
    ResponseEntity<Json_Response_User> getDetailClinicById(@Param("id") String id)
    {

        try {
            Clinic result =  clinicService.getDetailClinicById(id);


            if (result.getId()!=0)
            {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK",result)

                        );
            }
            else {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK","This clinic is empty!")

                        );
            }


        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Parameter missing",e)
                    );
        }

    }










}
