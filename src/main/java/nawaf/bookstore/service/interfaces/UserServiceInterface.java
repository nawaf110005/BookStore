package nawaf.bookstore.service.interfaces;

import nawaf.bookstore.model.User;

import java.util.List;

public interface UserServiceInterface {
    User saveUser(User userSignupDTO);

    List<User> getUsers();
}
