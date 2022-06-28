package com.clinicaOdontologica.clinicaOdontologica;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*    http
            .csrf().disable()
                        .authorizeRequests()
                        .antMatchers("/index.html").hasRole("USER")
                        .antMatchers("/studentAlta.html").hasRole("USER")
                        .antMatchers("/studentsList.html").hasRole("USER")
                        .anyRequest()
                        .permitAll()
                        .and()
                        .formLogin()
                        .and()
                        .logout();

}*/
}
