package lt.codeacademy.basketblog.service;
import lt.codeacademy.basketblog.exception.BlogPostNotFoundException;
import lt.codeacademy.basketblog.model.BlogPost;
import lt.codeacademy.basketblog.repository.BlogPostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public void addBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPost(UUID id) {
        return blogPostRepository.findById(id)
                .orElseThrow(BlogPostNotFoundException::new);
    }


    @Override
    public List<BlogPost> getBlogPost() {
        return blogPostRepository.findAll();
    }

    @Override
    public void update(BlogPost blogPost) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Page<BlogPost> getAllBlogPosts(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }

    @Override
    public BlogPost updateBlogPost(UUID id, BlogPost updatedBlogPost) {
        BlogPost blogPost = getBlogPost(id);
        blogPost.setTitle(updatedBlogPost.getTitle());
        blogPost.setContent(updatedBlogPost.getContent());
        return blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteBlogPost(UUID id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public BlogPost getByTitle(String title) {
        List<BlogPost> blogPosts = blogPostRepository.findByTitle(title);
        if (blogPosts.isEmpty()) {
            throw new BlogPostNotFoundException();
        }
        return blogPosts.get(0);
    }


    @Override
    public Page<BlogPost> getBlogPostsPaginated(Pageable pageable) {
        return blogPostRepository.findAll(pageable);
    }
}
