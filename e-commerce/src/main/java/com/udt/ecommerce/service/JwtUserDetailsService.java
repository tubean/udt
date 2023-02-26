package com.udt.ecommerce.service;

import com.udt.ecommerce.dao.UserDAO;
import com.udt.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDAO user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        String role = user.getRole().getName();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
        List<GrantedAuthority> grantedAuthorityList = Collections.singletonList(grantedAuthority);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(),
                grantedAuthorityList);
    }
}
