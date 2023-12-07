package lt.codeacademy.basketblog.controller;

import lt.codeacademy.basketblog.model.Comment;
import lt.codeacademy.basketblog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    public void addComment(@PathVariable(value = "id") UUID id, @RequestBody Comment comment) {
        commentService.save(id, comment);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable(value = "id") Long id, @RequestBody Comment comment) {
        commentService.update(id, comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }

}
