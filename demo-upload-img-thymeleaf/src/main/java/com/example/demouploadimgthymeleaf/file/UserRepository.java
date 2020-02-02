package com.example.demouploadimgthymeleaf.file;

import com.example.demouploadimgthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
