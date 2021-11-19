package com.example.adminservice.service;

import com.example.adminservice.entity.Admin;
import com.example.adminservice.dto.request.AdminRequestDTO;
import com.example.adminservice.dto.response.AdminResponseDTO;
import com.example.adminservice.dto.response.ResponseDTO;

import java.util.List;


public interface AdminService {

    void saveAdmin(AdminRequestDTO requestDTO);

    AdminResponseDTO searchAdmin(AdminRequestDTO requestDTO);

    Admin updateAdmin(AdminRequestDTO requestDTO);

    Admin fetchAdminByUsername(String username);




    ResponseDTO adminsToSendEmails();


    List<Admin> fetchAllAdmins();
}
