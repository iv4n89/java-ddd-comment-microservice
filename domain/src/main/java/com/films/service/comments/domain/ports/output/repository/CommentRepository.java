package com.films.service.comments.domain.ports.output.repository;

import com.films.service.comments.domain.models.Comment;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
  Comment save(Comment comment);

  Optional<Comment> findById(CommentId commentId);

  List<Comment> findByFilmId(FilmId filmId);

  List<Comment> findByUserId(UserId userId);

  void delete(CommentId commentId);

  Double getMeanRatingByFilmId(FilmId filmId);
}
