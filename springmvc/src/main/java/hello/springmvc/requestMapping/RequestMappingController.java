package hello.springmvc.requestMapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class RequestMappingController {

    @GetMapping
    public String users() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @PatchMapping("/{userId}")
    public String pathUser(@PathVariable String userId) {
        return "patch user: " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete user: " + userId;
    }
}
