package lt.codeacademy.basketblog.service;

import lt.codeacademy.basketblog.model.Comment;

import java.util.UUID;

public interface CommentService {

    void save(UUID productId, Comment comment);
    void delete(Long id);
    void update(Long commentId, Comment comment);
}
