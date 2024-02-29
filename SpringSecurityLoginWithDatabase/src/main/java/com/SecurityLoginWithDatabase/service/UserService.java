package com.SecurityLoginWithDatabase.service;

import com.SecurityLoginWithDatabase.entity.User;
import com.SecurityLoginWithDatabase.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
     User user=   userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail).orElseThrow(
             ()-> new UsernameNotFoundException("UserNameOrEmail Not Found")
     );
        Set<GrantedAuthority> authorities = user.getRoles()
                .stream().map(role->new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(usernameOrEmail,user.getPassword(),authorities);
    }

}
