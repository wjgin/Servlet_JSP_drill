package hello.thymeleaf.basic;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/basic")
public class BasicController {

    @GetMapping("text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    @GetMapping("text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!<b>");
        return "basic/text-escaped";
    }

    @GetMapping("variable")
    public String variableTest(Model model) {
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        ArrayList<User> users = new ArrayList<>();
        users.add(userA);
        users.add(userB);

        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put("userA", userA);
        userMap.put("userB", userB);

        model.addAttribute("userA", userA);
        model.addAttribute("users", users);
        model.addAttribute("userMap", userMap);

        return "basic/text-variable";
    }

    @Data
    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}
