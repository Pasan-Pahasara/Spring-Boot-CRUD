package lk.ijse.springbootcrud.controller;

import lk.ijse.springbootcrud.dto.UserDTO;
import lk.ijse.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class userController {
    @Autowired
    private UserService service;

    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        return service.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        return service.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO) {
        return service.updateUser(userDTO);
    }

    @DeleteMapping ("/deleteUser")
    public boolean deleteUser(@RequestBody UserDTO userDTO) {
        return service.deleteUser(userDTO);
    }
}
