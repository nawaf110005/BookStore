package nawaf.bookstore.controller;

import lombok.extern.slf4j.Slf4j;
import nawaf.bookstore.DTO.UserVerifyDTO;
import nawaf.bookstore.repository.UserRepository;
import nawaf.bookstore.service.impl.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

}