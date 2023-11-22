package com.films.service.comments.domain.ports.output.message.publisher;

import com.films.service.comments.domain.events.CommentDeletedEvent;
import com.films.system.common.domain.events.publisher.DomainPublisher;

public interface CommentDeletedRequestMessagePublisher
    extends DomainPublisher<CommentDeletedEvent> {}
