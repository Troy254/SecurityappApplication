package com.peerLending.securityapp.user.service;

import com.google.gson.Gson;
import com.peerLending.securityapp.user.model.SecurityUsers;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

  private RabbitTemplate rabbitTemplate;
  private static final Gson GSON = new Gson();

  @Autowired
  public NotificationService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(SecurityUsers securityUsers) {
    rabbitTemplate.convertAndSend("userRegisteredTopic", "user.registered",
        GSON.toJson(securityUsers));
  }
}
