package com.esd.assignment.services;

import com.esd.assignment.dto.LoginRequest;
import com.esd.assignment.dto.LoginResponse;
import com.esd.assignment.dto.RegisterRequest;
import com.esd.assignment.entities.Admin;
import org.springframework.stereotype.Service;
import com.esd.assignment.repository.AdminRepository;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final AdminRepository adminRepository;

    public AuthenticationService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public String registerAdmin(RegisterRequest registerRequest) {
        Optional<Admin> admin = adminRepository.findAdminByAdminEmail(registerRequest.getAdminEmail());

        if (admin.isPresent()) {
            return "Already Registered";
        }
        Admin admin1 = new Admin();
        admin1.setAdminEmail(registerRequest.getAdminEmail());
        admin1.setPassword(registerRequest.getPassword());
        admin1.setAdminName(registerRequest.getAdminName());
        admin1.setPhone(registerRequest.getPhone());

        adminRepository.save(admin1);
        return "Admin Registered Successfully";
    }

    public Admin loginAdmin(LoginRequest loginRequest) {
        Optional<Admin> admin = adminRepository.findAdminByAdminEmail(loginRequest.getAdminEmail());
        return admin.orElseGet(Admin::new);
    }
}
