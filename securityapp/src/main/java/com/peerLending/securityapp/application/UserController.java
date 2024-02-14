package com.peerLending.securityapp.application;

import com.peerLending.securityapp.user.model.SecurityUsers;
import com.peerLending.securityapp.user.repository.UserRepository;
import com.peerLending.securityapp.user.exception.UserNotFoundException;
import com.peerLending.securityapp.user.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserRepository userRepository;
  private NotificationService notificationService;

  @Autowired
  public UserController(UserRepository userRepository, NotificationService notificationService) {
    this.userRepository = userRepository;
    this.notificationService = notificationService;
  }

  @PostMapping("/register")
  public void register(@RequestBody SecurityUsers securityUsers) {
    userRepository.save(securityUsers);
    notificationService.sendMessage(securityUsers);
  }


  @PostMapping("/validate")
  public String validateTokenAndGetUsername(@RequestHeader("Authorization") String token) {
    return userRepository.findById(token)
        .orElseThrow(UserNotFoundException::new).getUsername();
  }

}
