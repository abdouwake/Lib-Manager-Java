package com.cgi.library.lib.manager.Controller;

import com.cgi.library.lib.manager.Model.User;
import com.cgi.library.lib.manager.ResponseEntity.ResponseHandler;
import com.cgi.library.lib.manager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/All")
    public ResponseEntity<Object> getAllUsers(){
        List<User> result = userService.getAllUsers();
        return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
    }

    @GetMapping("/All/{pageNumber}/{pageSize}")
    public ResponseEntity<Object> UsersPagination(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        Page<User> result = userService.getAllUsersPagination(pageNumber,pageSize);
        return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
    }

    @GetMapping("/findById/{idUser}")
    public ResponseEntity<Object> findUserById(@PathVariable Integer idUser){
        if(userService.existsById(idUser)){
            Optional<User> result; result= userService.findById(idUser);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, result);
        }else {
            return ResponseHandler.generateResponse("L'utilisateur n'existe pas.", HttpStatus.NOT_FOUND, null);
        }
    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer idUser) throws Exception{
        if(userService.existsById(idUser)){
             userService.deleteUser(idUser);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, true);
        }else{
            return ResponseHandler.generateResponse("L'utilisateur n'existe pas.", HttpStatus.NOT_FOUND, null);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addUser(@RequestBody User user) throws Exception{
        User userAdded =userService.addUser(user);
        return ResponseHandler.generateResponse("success", HttpStatus.OK, userAdded);
    }
}
