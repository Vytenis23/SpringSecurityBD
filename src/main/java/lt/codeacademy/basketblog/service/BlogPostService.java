package lt.codeacademy.basketblog.service;

import lt.codeacademy.basketblog.model.BlogPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * @author Andrius Baltrunas
 */
public interface BlogPostService {
    void addBlogPost(BlogPost blogPost);

    BlogPost getBlogPost(UUID uuid);

    List<BlogPost> getBlogPost();

    void update(BlogPost blogPost);

    void delete(UUID uuid);

    Page<BlogPost> getAllBlogPosts(Pageable pageable);

    BlogPost updateBlogPost(UUID id, BlogPost updatedBlogPost);

    void deleteBlogPost(UUID id);

    BlogPost getByTitle(String title);

    Page<BlogPost> getBlogPostsPaginated(Pageable pageable);
}
