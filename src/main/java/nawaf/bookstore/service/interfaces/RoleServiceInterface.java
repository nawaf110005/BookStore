package nawaf.bookstore.service.interfaces;

import nawaf.bookstore.model.Role;

public interface RoleServiceInterface {
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
}