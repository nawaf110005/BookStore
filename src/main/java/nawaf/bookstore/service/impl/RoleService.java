package nawaf.bookstore.service.impl;

import nawaf.bookstore.model.Role;
import nawaf.bookstore.model.User;
import nawaf.bookstore.repository.RoleRepository;
import nawaf.bookstore.repository.UserRepository;
import nawaf.bookstore.service.interfaces.RoleServiceInterface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService implements RoleServiceInterface {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    public Role saveRole(Role role) {
        log.info("Saving a new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    public void addRoleToUser(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }
}
