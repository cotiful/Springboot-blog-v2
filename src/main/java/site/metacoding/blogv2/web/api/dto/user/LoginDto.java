package site.metacoding.blogv2.web.api.dto.user;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {
    private String username;
    private String password;

    // 체크박스에 on라고 뜨기 때문에 String이라는걸 알 수 있다. 그리고 잘 모르겠으면 String 사용
    @Transient
    private String remember;
}
