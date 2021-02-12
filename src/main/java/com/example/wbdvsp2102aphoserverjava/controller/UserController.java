//package com.example.wbdvsp2102aphoserverjava.controller;
//
//import com.example.wbdvsp2102aphoserverjava.models.User;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//public class UserController {
//
//    // Starting list
//    private final User[] users = {
//            new User(123, "garySnail", "test", "Gary", "Snail", "STUDENT"),
//            new User(234, "sponge", "password", "Spongebob", "Squarepants", "STUDENT"),
//            new User(456, "pStar", "rocklove", "Patrick", "Star", "STUDENT"),
//            new User(678, "wardSquid", "tentacle", "Squidward", "Tentacles", "FACULTY"),
//            new User(890, "crab", "", "Mr", "Crabs", "ADMIN")
//    };
//    List<User> usersArrayList = new ArrayList<>(Arrays.asList(users));
//
//    // C
//    @PostMapping("/users")
//    public List<User> createUser(@RequestBody User user) {
//        this.usersArrayList.add(user);
//        listToString();
//        return Collections.unmodifiableList(this.usersArrayList);
//    }
//
//    // R
//    @GetMapping("/users")
//    public List<User> findAllUsers() {
//        listToString();
//        return Collections.unmodifiableList(this.usersArrayList);
//    }
//
//    // R
//    @GetMapping("/users/{id}")
//    public User findUserById(@PathVariable("id") long id) {
//        Optional<User> foundUser = usersArrayList.stream().
//                filter(u -> u.get_id() == (id)).
//                findFirst();
//        System.out.println("found the user: " + foundUser.toString() + "\n");
//        return foundUser.orElse(null);
//    }
//
//    // U
//    @PutMapping("/users/{id}")
//    public List<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        User userToUpdate = findUserById(id);
//        int index = usersArrayList.indexOf(userToUpdate);
//        System.out.println("replacing user at index: " + index + "user is: " + userToUpdate.toString() + "\n");
//        System.out.println("new user is: " + user.toString() + "\n");
//        usersArrayList.set(index, user);
//        listToString();
//        return Collections.unmodifiableList(this.usersArrayList);
//    }
//
//    // D
//    @DeleteMapping("/users/{id}")
//    public List<User> deleteUser(@PathVariable("id") long id) {
//        usersArrayList.removeIf(user -> user.get_id() == id);
//        listToString();
//        return Collections.unmodifiableList(this.usersArrayList);
//    }
//
//    private void listToString() {
//        for (User user : usersArrayList) {
//            System.out.println(user.toString() + "\n");
//        }
//    }
//}