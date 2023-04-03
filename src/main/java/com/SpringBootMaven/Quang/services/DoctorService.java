package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.*;
import com.SpringBootMaven.Quang.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoctorService {
    private final UserRepository userRepository;
    private final MarkDownRePository markDownRePository;
    private final Doctor_InforRePository doctorInforRePository;
    private final AllCodeRepository allCodeRepository;
    private final ScheduleRepository scheduleRepository;

    public DoctorService(UserRepository userRepository, MarkDownRePository markDownRePository, Doctor_InforRePository doctorInforRePository, AllCodeRepository allCodeRepository, ScheduleRepository scheduleRepository) {
        this.userRepository = userRepository;
        this.markDownRePository = markDownRePository;
        this.doctorInforRePository = doctorInforRePository;
        this.allCodeRepository = allCodeRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public List<User> findUsersByRoleDataKeyMapLimited(String roleDataKeyMap,int limit) {
        List<User> usersByRole = userRepository.findByRoleDataKeyMap(roleDataKeyMap);
        usersByRole = usersByRole.subList(0, Math.min(limit, usersByRole.size()));
        return usersByRole;
    }
    public List<User> findUsersByRoleDataKey(String roleDataKeyMap) {
        return userRepository.findByRoleDataKeyMap(roleDataKeyMap);
    }


    public String saveDetailDoctor(Json_Doctor_Request inputData){
        try {
            if (inputData.getAction().equals("CREATE"))
            {
                Markdown markdown = new Markdown();
                markdown.setContentHTML(inputData.getContentHTML());
                markdown.setContentMarkdown(inputData.getContentMarkdown());
                markdown.setDescription(inputData.getDescription());
                markdown.setUser(userRepository.findById(Integer.parseInt(inputData.getDoctorid())).orElse(new User()));
                markdown.setCreatedAt(LocalDateTime.now().toString());
                markdown.setUpdatedAt(LocalDateTime.now().toString());

                markDownRePository.save(markdown);



            }else if (inputData.getAction().equals("EDIT"))
            {
                Markdown markdown = markDownRePository.findByDoctorId(inputData.getDoctorid());
                if (markdown!=null)
                {
                    markdown.setContentHTML(inputData.getContentHTML());
                    markdown.setContentMarkdown(inputData.getContentMarkdown());
                    markdown.setDescription(inputData.getDescription());
                    markDownRePository.save(markdown);
                    markdown.setUpdatedAt(LocalDateTime.now().toString());
                }
                else {
                    return "This doctor is not exist";
                }
            }
            Doctor_Infor doctorInfor = doctorInforRePository.findByUserId(Integer.parseInt(inputData.getDoctorid()));
            if(doctorInfor!=null)
            {
                doctorInfor.setPriceTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedPrice()));
                doctorInfor.setProvinceTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedProvince()));
                doctorInfor.setPaymentTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedPayment()));
                doctorInfor.setNameClinic(inputData.getNameClinic());
                doctorInfor.setAddressClinic(inputData.getAddressClinic());
                doctorInfor.setNote(inputData.getNote());
                doctorInfor.setUpdatedAt(LocalDateTime.now().toString());

                doctorInforRePository.save(doctorInfor);

            }else {
                Doctor_Infor newDoctorInfor  = new Doctor_Infor();
                newDoctorInfor.setUser(userRepository.findById(Integer.parseInt(inputData.getDoctorid())).orElse(new User()));
                newDoctorInfor.setPriceTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedPrice()));
                newDoctorInfor.setProvinceTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedProvince()));
                newDoctorInfor.setPaymentTypeData(allCodeRepository.findByKeyMap(inputData.getSelectedPayment()));
                newDoctorInfor.setNameClinic(inputData.getNameClinic());
                newDoctorInfor.setAddressClinic(inputData.getAddressClinic());
                newDoctorInfor.setNote(inputData.getNote());
                newDoctorInfor.setCreatedAt(LocalDateTime.now().toString());
                newDoctorInfor.setUpdatedAt(LocalDateTime.now().toString());

                doctorInforRePository.save(newDoctorInfor);
            }
            return "Save infor doctor succed!";


        }catch (Exception e){
            return e.toString();
        }

    }

    public ResponseEntity<Json_Response_User> getScheduleByDate(String doctorid, String date)
    {
        try {
            List<Schedule> schedules = scheduleRepository.findByDoctorDataIdAndDate(doctorid,date);
            System.out.println(schedules.size());
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"OK",schedules)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"OK",e)

                    );
        }

    }

    public ResponseEntity<Json_Response_User> getExtraInforDoctorById(String doctorid)
    {
        try {

            Doctor_Infor doctorInfor = doctorInforRePository.findByUserId(Integer.parseInt(doctorid));
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",doctorInfor)

                    );

        }catch (Exception e)
        {
            System.out.println(e);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Param is missing",e)

                    );
        }

    }


    public ResponseEntity<Json_Response_User> getProfileDoctorById(String id)
    {
        try {

            User user = userRepository.findById(Integer.parseInt(id)).orElse(new User());
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(0,"OK",user)

                    );

        }catch (Exception e)
        {
            System.out.println(e);
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response_User(1,"Param is missing",e)

                    );
        }

    }






}
