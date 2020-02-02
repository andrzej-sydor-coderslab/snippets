package com.example.demouploadimgthymeleaf.file;

import com.example.demouploadimgthymeleaf.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@AllArgsConstructor
@Controller
public class UserController {
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model) {
        User user = userRepository.findById(1L).get();
        model.addAttribute("username", user.getName());

        byte[] file = user.getFile();
        String image = "";
        if (file != null && file.length > 0) {
            image = Base64.getEncoder().encodeToString(file);
        }
        model.addAttribute("image", image);

        return "/index";
    }

    @GetMapping("/upload")
    public String uploadForm() {
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String postUpload(@RequestParam("file") MultipartFile file) {
        User user = userRepository.findById(1L).get();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            user.setFile(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        userRepository.save(user);

        return "redirect:/";
    }

    @GetMapping("/removeImage")
    public String remove() {
        User user = userRepository.findById(1L).get();
        user.setFile(new byte[1]);
        userRepository.save(user);

        return "redirect:/";
    }
}