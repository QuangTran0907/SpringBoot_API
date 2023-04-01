package com.SpringBootMaven.Quang.controllers;

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



    @GetMapping("/get-all-users")
    @JsonView(Views.Public.class)
    ResponseEntity<Json_Response_User> getAllUser(@Param("id") String id)
    {
        List<User> users = repository.findAll();
        try {
            if(id.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                                new Json_Response_User(1,"Parameter missing",null )
                        );
            }
            else if (id.equals("ALL")){
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0,"Get all users successfully",users )
                );
            }else {
                User user = repository.findById(Integer.parseInt(id)).orElse(null);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0,"oke",user)

                );
            }
        }catch (Exception e)
        {
            System.out.println(e);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new Json_Response_User(0,e.toString(),null)

            );
        }

    }

    boolean checkMail(String mail)
    {
       User user = repository.findByEmail(mail);
         if (user==null)
         {
             return false;
         }
         return true;

    }
    @PostMapping("/create-new-user")
    ResponseEntity<Json_Response> insertUser(@RequestBody User newUser)
    {

        if(checkMail(newUser.getEmail()))
        {
            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(1,"Email already exists",null)

                    );
        }

        try {
            User user = new User(newUser.getEmail(), BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt(10)),newUser.getFirstName(),newUser.getLastName(),newUser.getAddress(),newUser.getPhonenumber(),newUser.getGenderData(),newUser.getImage(),newUser.getRoleData(),newUser.getPositionData(),newUser.getCreatedAt(),newUser.getUpdatedAt());
            repository.save(user);
            System.out.println("hhahahhahahahahaha"+BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt(10)));

            return
                    ResponseEntity.status(HttpStatus.OK).body(
                            new Json_Response(0,"OK",null)

                    );

        }catch (Exception e)
        {
            return
                    ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                            new Json_Response(1,"Parameter missing",null)
                    );
        }

    }
    @PutMapping("/edit-user")
    ResponseEntity<Json_Response_User> updateProduct(@RequestBody User newUser)
    {


        try {
            if(newUser==null)
            {
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new Json_Response_User(1, "Parameter missing", null)
                );
            }
            User user = repository.findById(newUser.getId()).orElse(new User(newUser.getEmail(), BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt(10)), newUser.getFirstName(), newUser.getLastName(), newUser.getAddress(), newUser.getPhonenumber(), newUser.getGenderData(), newUser.getImage(), newUser.getRoleData(), newUser.getPositionData(), newUser.getCreatedAt(), newUser.getUpdatedAt()));

            if(user.getEmail()!="") {
                user.setFirstName(newUser.getFirstName());
                user.setLastName(newUser.getLastName());
                user.setAddress(newUser.getAddress());
                repository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0, "Edit user success", null)
                );
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Json_Response_User(3, "Error", null)
            );

        }catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new Json_Response_User(3, "Error", null)
            );
        }


    }
    @DeleteMapping("/delete-user")
    ResponseEntity<Json_Response_User> deleteProduct(@Param("id") String id)
    {
        boolean exists = repository.existsById(Integer.parseInt(id));
        if (!exists){
            return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new Json_Response_User(2,"There are no user you chose ",null)
            );
        }
        repository.deleteById(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body(
                new Json_Response_User(0,"Delete user successfully", null)
        );
    }

    @JsonView(Views.Custom.class)
    @PostMapping("/login")
    ResponseEntity<Json_Response_User> handleLogin(@RequestBody User rq_user)
    {

        User user = repository.findByEmail(rq_user.getEmail().trim());
        if(user!=null)
        {
            Boolean checkpwd =  BCrypt.checkpw(rq_user.getPassword(),user.getPassword());
            if (checkpwd)
            {
                return ResponseEntity.status(HttpStatus.OK).body(
                        new Json_Response_User(0,"OK", user)
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
