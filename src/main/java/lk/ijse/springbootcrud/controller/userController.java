package lk.ijse.springbootcrud.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1 /user")
@CrossOrigin
public class userController {
    @GetMapping("/getUser")
    public String getUser() {
        return "ASUS VivoBook";
    }

    @PostMapping("/saveUser")
    public String saveUser() {
        return "User Saved..!";
    }
}
