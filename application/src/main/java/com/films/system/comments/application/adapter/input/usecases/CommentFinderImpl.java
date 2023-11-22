package com.films.system.comments.application.adapter.input.usecases;

import com.films.service.comments.domain.models.Comment;
import com.films.service.comments.domain.ports.input.usecases.CommentFinder;
import com.films.service.comments.domain.ports.output.repository.CommentRepository;
import com.films.system.common.domain.valueobject.CommentId;
import com.films.system.common.domain.valueobject.FilmId;
import com.films.system.common.domain.valueobject.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public final class CommentFinderImpl implements CommentFinder {

    private final CommentRepository commentRepository;

    @Override
    public Optional<Comment> findById(UUID commentId) {
        return commentRepository.findById(new CommentId(commentId));
    }

    @Override
    public List<Comment> findByFilmId(UUID filmId) {
        return commentRepository.findByFilmId(new FilmId(filmId));
    }

    @Override
    public List<Comment> findByUserId(UUID userId) {
        return commentRepository.findByUserId(new UserId(userId));
    }
}
