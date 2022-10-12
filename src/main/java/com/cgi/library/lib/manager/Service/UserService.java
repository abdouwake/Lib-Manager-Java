package com.cgi.library.lib.manager.Service;

import com.cgi.library.lib.manager.Model.Book;
import com.cgi.library.lib.manager.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public List<User> getAllUsers();
    public Page<User> getAllUsersPagination(Integer pageNumber, Integer pageSize);

    public <Optionnal> Optional<User> findById(Integer idUser);
    public Boolean existsById(Integer idUser);
    public void deleteUser(Integer idUser);
    public User addUser(User user);
}
