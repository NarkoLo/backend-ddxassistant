package com.ddxfitness.backend_ddxassistant.auth.service;

import com.ddxfitness.backend_ddxassistant.auth.repository.DDXUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class DDXUserDetailsService implements UserDetailsService {

    private final DDXUserRepository ddxUserRepository;

    public DDXUserDetailsService(DDXUserRepository ddxUserRepository) {
        this.ddxUserRepository = ddxUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ddxUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
