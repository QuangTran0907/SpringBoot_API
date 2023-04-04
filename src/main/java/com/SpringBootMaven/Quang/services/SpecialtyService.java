package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.Clinic;
import com.SpringBootMaven.Quang.models.Specialty;
import com.SpringBootMaven.Quang.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialtyService {
    @Autowired
    public final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    public String createSpecialty (Specialty specialty)
    {
        if(specialty.getName()==null||specialty.getDescription()==null)
        {
            return "Param is missing";
        }
        else {
            specialtyRepository.save(specialty);
            return "Create specialty successfully";
        }
    }

    public List<Specialty> getAllSpecialties()
    {
        return specialtyRepository.findAll();
    }

    public Specialty getDetailSpecialtyById(String id)
    {
        return specialtyRepository.findById(Integer.parseInt(id)).orElse(new Specialty());
    }



}
