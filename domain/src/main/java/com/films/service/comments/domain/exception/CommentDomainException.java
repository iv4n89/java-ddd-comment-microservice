package com.films.service.comments.domain.exception;

import com.films.system.common.domain.valueobject.DomainError;

public class CommentDomainException extends DomainError {
  public CommentDomainException(String message) {
    super(message);
  }
}
