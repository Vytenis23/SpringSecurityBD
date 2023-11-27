package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.exception.AppException;
import lt.codeacademy.eshop.exception.ProductNotFoundException;
import lt.codeacademy.eshop.model.Comment;
import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.repository.CommentRepository;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(ProductRepository productRepository, CommentRepository commentRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(UUID productId, Comment comment) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new AppException("Product not found", HttpStatus.NOT_FOUND));
        comment.setProduct(product);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void update(Long commentId, Comment comment) {
        Comment existingComment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new AppException("Comment not found", HttpStatus.NOT_FOUND));
        existingComment.setName(comment.getName());
        existingComment.setEmail(comment.getEmail());
        existingComment.setText(comment.getText());
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

}
