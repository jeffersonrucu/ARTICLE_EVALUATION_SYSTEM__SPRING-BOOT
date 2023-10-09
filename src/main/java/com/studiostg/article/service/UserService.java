package com.studiostg.article.service;

import com.studiostg.article.model.bean.User;
import com.studiostg.article.model.dao.UserRepository;
import com.studiostg.article.model.dto.user.UserCreateDTO;
import com.studiostg.article.model.dto.user.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> index() {
        return repository.findAll();
    }

    public User create(UserCreateDTO user) {
        User saveUser = new User(
            user.username(),
            user.password(),
            user.permission(),
            user.inactive(),
            user.person()
        );
        repository.save(saveUser);

        return saveUser;
    }

    public Optional<User> read(Long id) {
        return repository.findById(id);
    }

    public Optional<User> update(UserUpdateDTO userDTO) {
        Optional<User> userNew = repository.findById(userDTO.id());

        userNew.ifPresent(user -> {
            if(userDTO.username() != null) {
                user.setUsername(userDTO.username());
            }

            if(userDTO.password() != null) {
                user.setPassword(userDTO.password());
            }

            if(userDTO.inactive() != null) {
                user.setInactive(userDTO.inactive());
            }

            if(userDTO.permission() != null) {
                user.setPermission(userDTO.permission());
            }

            if(userDTO.person() != null) {

                if(userDTO.person().getName() != null) {
                    user.getPerson().setName(userDTO.person().getName());
                }

                if(userDTO.person().getGender() != null) {
                    user.getPerson().setGender(userDTO.person().getGender());
                }
            }

            repository.save(user);
        });

        return userNew;
    }

    public boolean delete(Long id) {
        boolean isExist = repository.existsById(id);

        if(isExist) repository.deleteById(id);

        return isExist;
    }
}
