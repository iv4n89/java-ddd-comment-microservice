package com.films.system.comments.messaging.mapper;

import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.valueobjects.CommentDescription;
import com.films.service.comments.domain.valueobjects.CommentRating;
import com.films.system.common.application.dto.message.CommentMessageDto;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class CommentMessageDataMapper {

  public Comment commentMessageDtoToComment(CommentMessageDto commentMessageDto) {
    return Comment.builder()
        .commentId(new CommentId(commentMessageDto.getId()))
        .description(new CommentDescription(commentMessageDto.getDescription()))
        .rating(new CommentRating(commentMessageDto.getRating()))
        .filmId(new FilmId(commentMessageDto.getFilmId()))
        .userId(new UserId(commentMessageDto.getUserId()))
        .createdAt(ZonedDateTime.of(commentMessageDto.getCreatedAt(), ZoneId.of("UTC")))
        .build();
  }

  public CommentMessageDto commentToCommentMessageDto(Comment comment) {
    return CommentMessageDto.builder()
        .id(comment.getCommentId().getValue())
        .description(comment.getDescription().getValue())
        .rating(comment.getRating().getValue())
        .filmId(comment.getFilmId().getValue())
        .userId(comment.getUserId().getValue())
        .createdAt(comment.getCreatedAt().toLocalDateTime())
        .build();
  }
}
