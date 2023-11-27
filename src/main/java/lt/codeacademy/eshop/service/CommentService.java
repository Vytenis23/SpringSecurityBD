package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.model.Comment;
import lt.codeacademy.eshop.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    void save(UUID productId, Comment comment);
    void delete(Long id);
    void update(Long commentId, Comment comment);
}
