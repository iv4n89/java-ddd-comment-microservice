package com.films.system.comments.messaging.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "comments-service")
public class CommentMessagingConfigData {
  private String commentCreatedRequestTopicName;
  private String commentCreatedResponseTopicName;
  private String commentDeletedRequestTopicName;
  private String commentDeletedResponseTopicName;
}
