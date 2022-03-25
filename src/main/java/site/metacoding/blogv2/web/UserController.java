package site.metacoding.blogv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // 로그아웃 - 로그인O
    // @GetMapping("/logout")
    // public String logout() {
    // session.invalidate(); //세션 무효화
    // return "redirect:/";
    // }

    // 웹브라우저 -> 회원가입 페이지 주세요 가능!
    // 앱-> 회원가입 페이지 주세요 말이 안됨!!!
    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        // // 쿠키로직
        // String cookieValue = request.getHeader("Cookie");

        return "user/loginForm";
    }

}
