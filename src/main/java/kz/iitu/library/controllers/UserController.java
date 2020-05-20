package kz.iitu.library.controllers;


import kz.iitu.library.models.User;
import kz.iitu.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello everyone!";
    }


    @GetMapping("/user={username}")
    public User findUserByName(@PathVariable String username){
        return userService.findUserByName(username);
    }

    //add user
    @PostMapping("")
    public void createUserByUsernamePassword(@RequestParam(name = "username")String username,@RequestParam(name = "password")String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);
    }


    @PostMapping("/{userid}/edit")
    public String editUser(@PathVariable Long userid,@RequestBody User user){
        if(userService.findUserById(userid) == null) {
            return ("User doesnt exist "+user);
        }
        userService.saveUser(user);
        return (user +" changed");
    }

    @PostMapping("/addCar")
    public boolean addCar(@RequestParam Long userId,@RequestParam Long carId){
        return userService.addCar(userId, carId);
    }

    @DeleteMapping("/deleteUser/{username}")
    public boolean deleteUserByName(@PathVariable String username) {
        if (userService.deleteUserByName(username) > 0) {
            return true;
        }
        return false;
    }

    @DeleteMapping("/cleanUsers")
    public void clear() {
        userService.clear();
    }
}
