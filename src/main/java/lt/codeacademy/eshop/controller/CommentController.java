package lt.codeacademy.eshop.controller;

import lt.codeacademy.eshop.model.Comment;
import lt.codeacademy.eshop.model.Product;
import lt.codeacademy.eshop.service.CommentService;
import lt.codeacademy.eshop.service.MessageService;
import lt.codeacademy.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
