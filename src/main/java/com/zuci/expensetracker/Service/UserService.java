package com.zuci.expensetracker.Service;

import com.zuci.expensetracker.Model.Registration;
import com.zuci.expensetracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Registration registration = userRepository.findByUsername(username);
        System.out.println(registration);
        if (registration == null) {
            throw new UsernameNotFoundException("username not exist");
        }
        List<GrantedAuthority> list = registration.getRoles().stream().map(e -> new SimpleGrantedAuthority(e.getRoleName())).collect(Collectors.toList());
        return new User(registration.getUsername(), registration.getUserPassword(), list);
    }
}
