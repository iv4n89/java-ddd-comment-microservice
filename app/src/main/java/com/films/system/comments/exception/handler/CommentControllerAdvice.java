package com.films.system.comments.exception.handler;

import com.films.service.comments.domain.exception.CommentDomainException;
import com.films.system.comments.application.exceptions.CommentNotFoundException;
import com.films.system.common.application.handler.ErrorDto;
import com.films.system.common.application.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class CommentControllerAdvice extends GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {CommentDomainException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto handleException(CommentDomainException commentDomainException) {
    log.error(commentDomainException.getMessage(), commentDomainException);
    return ErrorDto.builder()
        .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .message(commentDomainException.getMessage())
        .build();
  }

  @ResponseBody
  @ExceptionHandler(value = {CommentNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto handleException(CommentNotFoundException commentNotFoundException) {
    log.error(commentNotFoundException.getMessage(), commentNotFoundException);
    return ErrorDto.builder()
        .code(HttpStatus.NOT_FOUND.getReasonPhrase())
        .message(commentNotFoundException.getMessage())
        .build();
  }
}
