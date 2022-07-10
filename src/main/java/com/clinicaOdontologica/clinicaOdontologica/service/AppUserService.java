package com.clinicaOdontologica.clinicaOdontologica.service;

import com.clinicaOdontologica.clinicaOdontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    private final IUserRepository iUserRepository;

    @Autowired
    public AppUserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return iUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("el email del usuario no fue encontrado"));
    }
}
