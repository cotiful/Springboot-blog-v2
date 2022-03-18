package site.metacoding.blogv2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {
    // 모든 페이지 잘 작동하는지 확인 후 푸시 - 2.페이지 작동 테스트

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/detail")
    public String detail() {
        return "user/detail";
    }

    @GetMapping("/update")
    public String update() {
        return "user/updateForm";
    }

    @GetMapping("/post/detail")
    public String pdetail() {
        return "post/detail";
    }

    @GetMapping("/post/list")
    public String list() {
        return "post/list";
    }

    @GetMapping("/post/updateForm")
    public String updateForm() {
        return "post/updateForm";
    }

    @GetMapping("/post/writeForm")
    public String write() {
        return "post/writeForm";
    }

}
