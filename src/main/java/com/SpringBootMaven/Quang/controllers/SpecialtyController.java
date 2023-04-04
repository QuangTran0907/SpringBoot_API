package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Clinic;
import com.SpringBootMaven.Quang.models.Json_Response_User;
import com.SpringBootMaven.Quang.models.Specialty;
import com.SpringBootMaven.Quang.services.SpecialtyService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }


    @PostMapping("/create-new-specialty")
    ResponseEntity<Json_Response_User> createSpecialty(@RequestBody Specialty specialty)
    {

        try {
            String result =  specialtyService.createSpecialty(specialty);


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

    @GetMapping("/get-specialty")
    ResponseEntity<Json_Response_User> getAllSpecialty()
    {

        try {
            List<Specialty> allSpecialties = specialtyService.getAllSpecialties();
            if (allSpecialties.size()>0)
            {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK",allSpecialties)

                        );
            }
            else {
                return
                        ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(0,"OK","Spetialty is empty!")

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

    @GetMapping("/get-detail-specialty-by-id")
    ResponseEntity<Json_Response_User> getDetailSpecialtyById(@Param("id") String id)
    {

        try {
            Specialty result =  specialtyService.getDetailSpecialtyById(id);


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
                                new Json_Response_User(0,"OK","This specialty is empty!")

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
