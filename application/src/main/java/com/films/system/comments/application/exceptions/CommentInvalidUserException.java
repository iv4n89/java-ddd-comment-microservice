package com.films.system.comments.application.exceptions;

public class CommentInvalidUserException extends RuntimeException {

  public CommentInvalidUserException(String message) {
    super(message);
  }
}
