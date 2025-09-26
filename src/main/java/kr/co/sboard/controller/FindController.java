package kr.co.sboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FindController {

    @GetMapping("/find/changePassword")
    public String changePassword(){
        return "find/changePassword";
    }
    @GetMapping("/find/Password")
    public String Password(){
        return "find/Password";
    }
    @GetMapping("/find/resultUserId")
    public String resultUserId(){
        return "find/resultUserId";
    }
    @GetMapping("/find/userId")
    public String userId(){
        return "find/userId";
    }
}
