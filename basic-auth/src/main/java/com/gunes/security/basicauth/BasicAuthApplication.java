package com.gunes.security.basicauth;

import com.gunes.security.basicauth.dto.CreateUserRequest;
import com.gunes.security.basicauth.model.Role;
import com.gunes.security.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

    private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData(){
        CreateUserRequest request = CreateUserRequest.builder()
                .name("Sezer")
                .username("szr")
                .password("pass1")
                .authorities(Set.of(Role.ROLE_USER))
                .build();
        userService.createUser(request);

        CreateUserRequest request2 = CreateUserRequest.builder()
                .name("Serkan")
                .username("gunes")
                .password("pass2")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();
        userService.createUser(request2);
    }
}
