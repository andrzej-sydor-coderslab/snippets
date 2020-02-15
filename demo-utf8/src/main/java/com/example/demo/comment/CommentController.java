package com.example.demo.comment;

import com.example.demo.model.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class CommentController {
    private CommentService commentService;

    @GetMapping("/")
    public String home(Model model) {
        List<Comment> comments = commentService.findAll();
        model.addAttribute("comments", comments);
        return "/list";
    }

    @GetMapping("/add")
    public String editForm(Model model) {
        Comment comment = new Comment();
        model.addAttribute("comment", comment);
        return "addForm";
    }

    @PostMapping("/add")
    public String postUpload(Comment comment) {
        commentService.save(comment);

        return "redirect:/";
    }
}
