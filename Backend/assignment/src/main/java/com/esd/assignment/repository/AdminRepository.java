package com.esd.assignment.repository;

import com.esd.assignment.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<Admin> findAdminByAdminEmail(String adminEmail);
}
