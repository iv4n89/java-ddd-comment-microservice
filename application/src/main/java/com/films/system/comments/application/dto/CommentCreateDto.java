package com.films.system.comments.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentCreateDto(
    UUID id,
    String description,
    Integer rating,
    UUID filmId,
    UUID userId,
    LocalDateTime createdAt) {}
