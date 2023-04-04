package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.Clinic;
import com.SpringBootMaven.Quang.repositories.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {
    @Autowired
    public final ClinicRepository clinicRepository;

    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public String createClinic(Clinic clinic)
    {
        if(clinic.getName()==null||clinic.getAddress()==null||clinic.getAddress()==null||clinic.getDescription()==null)
        {
            return "Param is missing";
        }
        else {
            clinicRepository.save(clinic);
            return "Add clinic successfully";
        }
    }
    public List<Clinic> allClinic()
    {
        return clinicRepository.findAll();
    }

    public Clinic getDetailClinicById(String id)
    {
        return clinicRepository.findById(Integer.parseInt(id)).orElse(new Clinic());
    }



}
