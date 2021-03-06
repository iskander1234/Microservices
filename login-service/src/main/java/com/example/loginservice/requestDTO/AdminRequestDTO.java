package com.example.loginservice.requestDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequestDTO implements Serializable {
    private String username;
    private String emailAddress;
}
