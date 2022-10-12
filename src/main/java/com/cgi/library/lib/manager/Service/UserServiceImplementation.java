package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.User;
import com.cgi.library.lib.manager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getAllUsersPagination(Integer pageNumber, Integer pageSize) {
        Pageable peagable = PageRequest.of(pageNumber,pageSize);
        return userRepository.findAll(peagable);
    }

    @Override
    public Optional<User> findById(Integer idUser) {
        return userRepository.findById(idUser);
    }

    @Override
    public Boolean existsById(Integer idUser) {
        return userRepository.existsById(idUser);
    }

    @Override
    public void deleteUser(Integer idUser) {
         userRepository.deleteById(idUser);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
