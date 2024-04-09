package org.example.service;


import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    //public void deleteById(int id)
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    public User getOne(int id) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id));
        return userOptional.orElse(null);
    }

    public User update(User user) {
        // Проверяем, существует ли пользователь с таким ID
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        } else {
            // Если пользователя с таким ID нет, можно выбросить исключение или вернуть null,
            // в зависимости от вашей бизнес-логики
            return null;
        }
    }
}