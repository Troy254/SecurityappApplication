package com.peerLending.securityapp.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityUsersDTO {
  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private int age;
  private String occupation;
}
