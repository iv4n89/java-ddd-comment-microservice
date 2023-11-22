package com.films.system.comments.controllers;

import com.films.service.comments.domain.ports.input.service.CommentApplicationService;
import com.films.system.comments.application.dto.CommentCreateDto;
import com.films.system.comments.application.dto.CommentResponseDto;
import com.films.system.comments.infrastructure.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentsController {
  private final CommentApplicationService commentApplicationService;
  private final CommentMapper commentMapper;

  @GetMapping("/film/{id}")
  public ResponseEntity<List<CommentResponseDto>> findByFilmId(@PathVariable UUID id) {
    List<CommentResponseDto> comments =
        commentApplicationService.findByFilmId(id).stream()
            .map(commentMapper::commentToCommentResponseDto)
            .toList();
    return ResponseEntity.ok(comments);
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<List<CommentResponseDto>> findByUserId(@PathVariable UUID id) {
    List<CommentResponseDto> comments =
        commentApplicationService.findByUserId(id).stream()
            .map(commentMapper::commentToCommentResponseDto)
            .toList();

    return ResponseEntity.ok(comments);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentResponseDto> findById(@PathVariable UUID id) {
    CommentResponseDto comment =
        commentApplicationService
            .findById(id)
            .map(commentMapper::commentToCommentResponseDto)
            .orElseThrow();
    return ResponseEntity.ok(comment);
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody CommentCreateDto commentCreateDto) {
    commentApplicationService.create(
        commentCreateDto.id(),
        commentCreateDto.description(),
        commentCreateDto.rating(),
        commentCreateDto.filmId(),
        commentCreateDto.userId(),
        commentCreateDto.createdAt());
    return ResponseEntity.created(URI.create("/comments")).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
    commentApplicationService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
