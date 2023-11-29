package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.BlogPost;
import lt.codeacademy.eshop.model.BlogPost;
import lt.codeacademy.eshop.service.BlogPostService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class BlogPostsController {

    private final BlogPostService blogPostService;

    public BlogPostsController(@Qualifier("blogPostServiceImpl") BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping
    public List<BlogPost> getAll() {
        return blogPostService.getBlogPost();
    }

    @GetMapping("/{id}")
    public BlogPost getBlogPostDetail(@PathVariable(value = "id") UUID id) {
        return blogPostService.getBlogPost(id);
    }

    @PostMapping
    public void save(@RequestBody BlogPost blogPost) {
        blogPostService.addBlogPost(blogPost);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        blogPostService.delete(id);
    }
}
