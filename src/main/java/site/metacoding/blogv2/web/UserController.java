package site.metacoding.blogv2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;

@RequiredArgsConstructor
@Controller // 파일
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    // 앱은 이 친구 요청할까? 아니
    // 웹은 이 친구 요청해야함.
    @GetMapping("/s/user/{id}")
    public String userInfo(@PathVariable Integer id, Model model) {
        User userEntity = userService.회원정보(id);
        model.addAttribute("user", userEntity);
        return "user/updateForm";
    }

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
