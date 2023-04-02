package com.SpringBootMaven.Quang.services;

import com.SpringBootMaven.Quang.models.Json_Response;
import com.SpringBootMaven.Quang.models.User;
import com.SpringBootMaven.Quang.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final UserRepository userRepository;
    public DoctorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findUsersByRoleDataKeyMapLimited(String roleDataKeyMap,int limit) {
        List<User> usersByRole = userRepository.findByRoleDataKeyMap(roleDataKeyMap);
        usersByRole = usersByRole.subList(0, Math.min(limit, usersByRole.size()));
        return usersByRole;
    }
    public List<User> findUsersByRoleDataKey(String roleDataKeyMap) {
        return userRepository.findByRoleDataKeyMap(roleDataKeyMap);
    }


}
