package com.films.system.comments.infrastructure.mapper;

import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.valueobjects.CommentDescription;
import com.films.service.comments.domain.valueobjects.CommentRating;
import com.films.system.comments.application.dto.CommentResponseDto;
import com.films.system.comments.infrastructure.entity.CommentEntity;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class CommentMapper {

  public Comment commentEntityToComment(CommentEntity commentEntity) {
    return Comment.builder()
        .commentId(new CommentId(commentEntity.getId()))
        .description(new CommentDescription(commentEntity.getDescription()))
        .rating(new CommentRating(commentEntity.getRating()))
        .filmId(new FilmId(commentEntity.getFilmId()))
        .userId(new UserId(commentEntity.getUserId()))
        .createdAt(ZonedDateTime.of(commentEntity.getCreatedAt(), ZoneId.of("UTC")))
        .build();
  }

  public CommentEntity commentToCommentEntity(Comment comment) {
    return CommentEntity.builder()
        .id(comment.getCommentId().getValue())
        .description(comment.getDescription().getValue())
        .rating(comment.getRating().getValue())
        .filmId(comment.getFilmId().getValue())
        .userId(comment.getUserId().getValue())
        .createdAt(comment.getCreatedAt().toLocalDateTime())
        .build();
  }

  public CommentResponseDto commentToCommentResponseDto(Comment comment) {
    return CommentResponseDto.builder()
        .id(comment.getCommentId().getValue())
        .description(comment.getDescription().getValue())
        .rating(comment.getRating().getValue())
        .filmId(comment.getFilmId().getValue())
        .userId(comment.getUserId().getValue())
        .createdAt(comment.getCreatedAt())
        .build();
  }
}
