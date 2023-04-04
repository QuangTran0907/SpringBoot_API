package com.SpringBootMaven.Quang.controllers;

import com.SpringBootMaven.Quang.models.Response.*;
import com.SpringBootMaven.Quang.models.Views;
import com.SpringBootMaven.Quang.models.*;
import com.SpringBootMaven.Quang.repositories.AllCodeRepository;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping(path = "/api/v1")
public class UserController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AllCodeRepository allCodeRepository;


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get-all-user")
    @JsonView(Views.Custom.class)
    ResponseEntity<Json_Response_Users> getAllUser(@Param("id") String id)
    {
        List<User> users = repository.findAll();
        try {
            if(id.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_Users(1,"Parameter missing",null )
                );
            }
            else if (id.equals("ALL")){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_Users(0,"Get all users successfully",users )
                );
            }else {
                User user = repository.findById(Integer.parseInt(id)).orElse(null);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_Users(0,"oke",user)

                );
            }
        }catch (Exception e)
        {
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response_Users(0,e.toString(),null)

            );
        }

    }

    boolean checkMail(String mail)
    {
        User users = repository.findByEmail(mail);
        if (users==null)
        {
            return false;
        }
        return true;

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create-new-user")
    ResponseEntity<Json_Response> insertUser(@RequestBody JsonUser jsonUser)
    {

        if(checkMail(jsonUser.getEmail()))
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(1,"Email already exists",null)

                    );
        }

        try {
            User user = new User();
            user.setPassword(BCrypt.hashpw(jsonUser.getPassword(),BCrypt.gensalt(10)));
            user.setEmail(jsonUser.getEmail());
            user.setPhonenumber(jsonUser.getPhonenumber());
            user.setAddress(jsonUser.getAddress());
            user.setFirstName(jsonUser.getFirstName());
            user.setLastName((jsonUser.getLastName()));
            user.setImage(jsonUser.getAvatar());
            user.setGenderData(allCodeRepository.findByKeyMap(jsonUser.getGender()));
            user.setPositionData(allCodeRepository.findByKeyMap(jsonUser.getPositionid()));
            user.setRoleData(allCodeRepository.findByKeyMap(jsonUser.getRoleid()));

            repository.save(user);


            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(0,"OK",null)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(1,"Parameter missing",null)
                    );
        }

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/edit-user")
    ResponseEntity<Json_Response_User> updateProduct(@RequestBody JsonUser jsonUser)
    {

        System.out.println("Check" + jsonUser.toString());

        try {
            if(jsonUser.getEmail()==null || jsonUser.getFirstName() == null || jsonUser.getLastName() == null
                    || jsonUser.getAddress() == null || jsonUser.getPhonenumber()==null )
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(1, "Parameter missing", null)
                );
            }else {
                User user = repository.findByEmail(jsonUser.getEmail());
                user.setEmail(jsonUser.getEmail());
                user.setPhonenumber(jsonUser.getPhonenumber());
                user.setAddress(jsonUser.getAddress());
                user.setFirstName(jsonUser.getFirstName());
                user.setLastName((jsonUser.getLastName()));
                user.setImage(jsonUser.getAvatar());
                user.setGenderData(allCodeRepository.findByKeyMap(jsonUser.getGender()));
                user.setPositionData(allCodeRepository.findByKeyMap(jsonUser.getPositionid()));
                user.setRoleData(allCodeRepository.findByKeyMap(jsonUser.getRoleid()));
                repository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0, "Insert ngon lanh", null)
                );
            }
        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response_User(3, "Error", null)
            );
        }


    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/delete-user")
    ResponseEntity<Json_Response_User> deleteProduct(@RequestBody JonDeleteUser jonDeleteUser)
    {

        boolean exists = repository.existsById(Integer.parseInt(jonDeleteUser.getId()));
        if (!exists){
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response_User(2,"There are no user you chose ",null)
            );
        }
        repository.deleteById(Integer.parseInt(jonDeleteUser.getId()));
        return ResponseEntity.status(HttpStatus.OK).body(
                new Json_Response_User(0,"Delete user successfully", null)
        );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    @JsonView(Views.Public.class)
    ResponseEntity<Json_Response_User> handleLogin(@RequestBody User rq_user)
    {

        User user = repository.findByEmail(rq_user.getEmail().trim());
        if(user!=null)
        {
            JsonLogin userJson = new JsonLogin(user.getId(),user.getEmail(),user.getRoleData().getKeyMap(),user.getFirstName(),user.getLastName());
            Boolean checkpwd =  BCrypt.checkpw(rq_user.getPassword(),user.getPassword());
            if (checkpwd)
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0,"OK", userJson)
                );
            }
            else {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(3,"wrong password", null)
                );
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response_User(2,"Your email not found", null)
            );
        }

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allcodes")
    ResponseEntity<Json_Response> getAllCodes(@Param("type") String type)
    {


        try {
            if(type.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response(1,"Parameter missing",null )
                );
            }
            else {
                List<AllCode> allCodes = allCodeRepository.findByType(type);
                System.out.println(allCodes.size());
                if (allCodes.size()!=0)
                {
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(0,"OK",allCodes)

                    );
                }
                else {
                    return ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(1,"Parameter missing",null)

                    );
                }

            }
        }catch (Exception e)
        {
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response(1,e.toString(),null)

            );
        }

    }

}
