package com.udt.ecommerce.service;

import com.udt.ecommerce.dao.RoleDAO;
import com.udt.ecommerce.dao.UserDAO;
import com.udt.ecommerce.dto.UserDTO;
import com.udt.ecommerce.repository.RoleRepository;
import com.udt.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bcryptEncoder;

    public UserDAO save(UserDTO user) {
        UserDAO newUser = new UserDAO();
        LocalDate now = LocalDate.now();
        newUser.setUsername(user.getUsername());
        newUser.setPasswordHash(bcryptEncoder.encode(user.getPassword()));

        RoleDAO roleDAO = roleRepository.findById(user.getRoleId());
        newUser.setRole(roleDAO);

        newUser.setCreatedAt(now);
        newUser.setUpdatedAt(now);
        return userRepository.save(newUser);
    }
}
