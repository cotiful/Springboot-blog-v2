package site.metacoding.blogv2.web.api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.user.User;
import site.metacoding.blogv2.service.UserService;
import site.metacoding.blogv2.web.api.dto.ResponseDto;
import site.metacoding.blogv2.web.api.dto.user.JoinDto;
import site.metacoding.blogv2.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/logout")
    public ResponseDto<?> logout() {
        session.invalidate();
        return new ResponseDto<>(1, "성공", null);
    }

    @PostMapping("/join")
    public ResponseDto<?> join(@RequestBody JoinDto joinDto) {

        userService.회원가입(joinDto);
        return new ResponseDto<>(1, "회원가입성공", null);
    }

    @PostMapping("/login")
    // 톰캣이 만들어줌 httpservletResponse
    public ResponseDto<?> login(@RequestBody LoginDto loginDto, HttpServletResponse response) {
        User userEntity = userService.로그인(loginDto);

        // 오류가 터지지는 않고 알려줌의 용도
        if (userEntity == null) {
            return new ResponseDto<>(-1, "로그인실패", null);
        }

        if (loginDto.getRemember().equals("on")) {

            // 쿠키 로직 (원형)
            // response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() +
            // ";path=/");
        }
        response.addHeader("Set-Cookie", "remember=" + loginDto.getUsername() +
                ";path=/ httponly=true");

        // addHeader와 똑같은 내용이다.
        // Cookie cookie = new Cookie("remember", loginDto.getUsername());
        // cookie,setPath("/")
        // response.addCookie(cookie);

        session.setAttribute("principal", userEntity);
        return new ResponseDto<String>(1, "로그인성공", null);
    }

}
