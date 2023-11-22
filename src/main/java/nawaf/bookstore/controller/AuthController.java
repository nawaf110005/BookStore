package nawaf.bookstore.controller;

import lombok.extern.slf4j.Slf4j;
import nawaf.bookstore.DTO.UserVerifyDTO;
import nawaf.bookstore.model.Book;
import nawaf.bookstore.repository.UserRepository;
import nawaf.bookstore.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import nawaf.bookstore.model.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/verify")
    @ResponseStatus(HttpStatus.OK)
    public UserVerifyDTO verifyToken(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        User userFromDb = userRepository.findByEmail(email);
        UserVerifyDTO userVerifyDTO = new UserVerifyDTO(userFromDb.getName(), userFromDb.getId());
//        Gson gson = new Gson();
//        String userDetails = gson.toJson(userVerifyDTO);
        return userVerifyDTO;
    }
}