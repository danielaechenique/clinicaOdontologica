package com.clinicaOdontologica.clinicaOdontologica.repository;

import com.clinicaOdontologica.clinicaOdontologica.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.name = :name")
    Optional<User> getUserByName(@Param("name") String name);
}
