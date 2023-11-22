package com.films.system.comments.infrastructure.repository;

import com.films.system.comments.infrastructure.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentEntity, UUID> {
  List<CommentEntity> findByFilmId(UUID filmId);

  List<CommentEntity> findByUserId(UUID userId);

  @Query("SELECT AVG(c.rating) FROM CommentEntity c WHERE c.filmId = :filmId")
  Double findMeanRatingByFilmId(@Param("filmId") UUID filmId);
}
