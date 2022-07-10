package com.clinicaOdontologica.clinicaOdontologica.login;

import com.clinicaOdontologica.clinicaOdontologica.model.AppUser;
import com.clinicaOdontologica.clinicaOdontologica.model.AppUsuarioRoles;
import com.clinicaOdontologica.clinicaOdontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private IUserRepository iUserRepository;

    @Autowired
    public DataLoader(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        iUserRepository.save(new AppUser("daniela", "daniela", "daniela@gmail.com", password, AppUsuarioRoles.ADMIN));
        iUserRepository.save(new AppUser("daniela2", "daniela2", "daniela2@gmail.com", password2, AppUsuarioRoles.USER));
    }
}
