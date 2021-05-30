package be.iccbxl.pid.service;

import be.iccbxl.pid.exception.UserLoginUniqueConstraintViolation;
import be.iccbxl.pid.model.RoleUser;
import be.iccbxl.pid.model.User;
import be.iccbxl.pid.repository.RoleUserRepository;
import be.iccbxl.pid.repository.UserRepository;
import javassist.compiler.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleUserRepository roleUserRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    User getUserById(String id) {
        Long indice = (long) (Integer.parseInt(id));
        return userRepository.findById(indice).orElse(null);
    }


    public User getUserByLogin(String login) {
        List<User> byLogin = userRepository.findByLogin(login);
        if (byLogin == null || byLogin.isEmpty()) {
            return null;
        } else if (byLogin.size() > 1) {
            throw new UserLoginUniqueConstraintViolation("Login already exist" + login);
        } else {
            return byLogin.get(0);
        }
    }

    public void deleteUser(String id) {
        Long indice = (long) (Integer.parseInt(id));
        userRepository.deleteById(indice);
    }


    public String[] getRolesOf(User user) {
        List<RoleUser> all = roleUserRepository.findByUser(user);
        String[] roles = {};
        if (all != null && !all.isEmpty()) {
            roles = all.stream()
                    .map(roleUser -> roleUser.getRole())
                    .filter(role -> !Objects.isNull(role))
                    .map(role -> role.getRole())
                    .toArray(String[]::new);
        }
        return roles;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
