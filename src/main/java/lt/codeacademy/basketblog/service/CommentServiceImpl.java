package lt.codeacademy.basketblog.service;

import lt.codeacademy.basketblog.exception.AppException;
import lt.codeacademy.basketblog.model.BlogPost;
import lt.codeacademy.basketblog.model.Comment;
import lt.codeacademy.basketblog.repository.BlogPostRepository;
import lt.codeacademy.basketblog.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void save(UUID blogPostId, Comment comment) {
        BlogPost blogPost = blogPostRepository
                .findById(blogPostId)
                .orElseThrow(() -> new AppException("Blog post not found", HttpStatus.NOT_FOUND));
        comment.setBlogPost(blogPost);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void update(Long commentId, Comment updatedComment) {
        Comment existingComment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new AppException("Comment not found", HttpStatus.NOT_FOUND));

        existingComment.setName(updatedComment.getName());
        existingComment.setEmail(updatedComment.getEmail());
        existingComment.setText(updatedComment.getText());
    }

    @Override
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
