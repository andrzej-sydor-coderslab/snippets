package com.example.demouploadimgthymeleaf;

import com.example.demouploadimgthymeleaf.file.UserRepository;
import com.example.demouploadimgthymeleaf.model.User;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void test() {
        User user = new User();

        userRepository.save(user);

        assertThat(user.getId(), CoreMatchers.notNullValue());
        assertThat(userRepository.count(), is(1L));
    }
}
