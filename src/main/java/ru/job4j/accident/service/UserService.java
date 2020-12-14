package ru.job4j.accident.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.AuthorityRepository;
import ru.job4j.accident.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository users;
    private final AuthorityRepository authorities;
    private final PasswordEncoder encoder;

    public UserService(UserRepository users, AuthorityRepository authorities, PasswordEncoder encoder) {
        this.users = users;
        this.authorities = authorities;
        this.encoder = encoder;
    }

    public void save(User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorities.findByAuthority("ROLE_USER"));
        users.save(user);
    }
}
