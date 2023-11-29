package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {


    List<BlogPost> findByTitle(String title);
}
