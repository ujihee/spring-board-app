package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.config.AppInfo;
import kr.co.sboard.dto.TermsDTO;
import kr.co.sboard.dto.UserDTO;
import kr.co.sboard.service.TermsService;
import kr.co.sboard.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final TermsService termsService;//final선언하면 @required~로 객체 주입
    private final UserService userService;

    @GetMapping("/user/info")
    public String info(){
        return "user/info";
    }//여기서 interceptor수행


    @GetMapping("/user/login")
    public String login(){
        //model.addAttribute(appInfo);
        return "user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO, HttpServletRequest req){

        String regip = req.getRemoteAddr();
        userDTO.setReg_ip(regip);

        userService.save(userDTO);
        return "redirect:/user/login";
    }

    @GetMapping("/user/terms")
    public String terms(Model model){

        TermsDTO termsDTO = termsService.getTerms(1);
        model.addAttribute(termsDTO);

        return "user/terms";
    }

    //API 요청 메서드 - 중복확인이 4개니까 4개있어야 하는데 작성한거 활용하자
    @ResponseBody
    @GetMapping("/user/{type}/{value}")
    public ResponseEntity<Map<String, Integer>> getUser(@PathVariable("type") String type,
                                                        @PathVariable("value") String value){
        log.info("type = {}, value = {}", type, value);

        int count = userService.countUser(type, value);


        // Json 생성
        Map<String,Integer> map = Map.of("count",count);

        return ResponseEntity.ok(map);

    }
}
