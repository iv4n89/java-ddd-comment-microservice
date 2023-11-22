package com.films.system.comments.infrastructure.adapter.output.repository;

import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.ports.output.repository.CommentRepository;
import com.films.system.comments.application.exceptions.CommentInvalidUserException;
import com.films.system.comments.application.exceptions.CommentNotFoundException;
import com.films.system.comments.infrastructure.entity.CommentEntity;
import com.films.system.comments.infrastructure.mapper.CommentMapper;
import com.films.system.comments.infrastructure.repository.CommentJpaRepository;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CommentRepositoryImpl implements CommentRepository {

  private final CommentJpaRepository commentJpaRepository;
  private final CommentMapper commentMapper;

  @Override
  @Transactional
  public Comment save(Comment comment) {
    CommentEntity commentEntity = commentMapper.commentToCommentEntity(comment);
    if (commentJpaRepository.existsById(comment.getCommentId().getValue())) {
      CommentEntity commentDb = commentJpaRepository.findById(commentEntity.getId()).orElseThrow();
      if (!commentDb.getUserId().equals(commentEntity.getUserId())) {
        throw new CommentInvalidUserException("This comment is not yours!");
      }
    }
    return commentMapper.commentEntityToComment(commentJpaRepository.save(commentEntity));
  }

  @Override
  public Optional<Comment> findById(CommentId commentId) {
    return commentJpaRepository
        .findById(commentId.getValue())
        .map(commentMapper::commentEntityToComment);
  }

  @Override
  public List<Comment> findByFilmId(FilmId filmId) {
    return commentJpaRepository.findByFilmId(filmId.getValue()).stream()
        .map(commentMapper::commentEntityToComment)
        .toList();
  }

  @Override
  public List<Comment> findByUserId(UserId userId) {
    return commentJpaRepository.findByUserId(userId.getValue()).stream()
        .map(commentMapper::commentEntityToComment)
        .toList();
  }

  @Override
  public void delete(CommentId commentId) {
    if (!commentJpaRepository.existsById(commentId.getValue())) {
      throw new CommentNotFoundException(
          "Comment with id: " + commentId.getValue().toString() + " could not be found");
    }
    commentJpaRepository.deleteById(commentId.getValue());
  }

  @Override
  public Double getMeanRatingByFilmId(FilmId filmId) {
    return commentJpaRepository.findMeanRatingByFilmId(filmId.getValue());
  }
}
