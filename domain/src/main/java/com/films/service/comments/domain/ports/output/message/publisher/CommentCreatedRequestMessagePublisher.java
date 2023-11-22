package com.films.service.comments.domain.ports.output.message.publisher;

import com.films.service.comments.domain.events.CommentCreatedEvent;
import com.films.system.common.domain.events.publisher.DomainPublisher;

public interface CommentCreatedRequestMessagePublisher
    extends DomainPublisher<CommentCreatedEvent> {}
