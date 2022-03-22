package site.metacoding.blogv2.web.api.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.user.User;

//DT0: Data Transfer Obejct (통신으로 전달하거나 받는 오브젝트를 엔티티 타입으로 변환)

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {
    private String username;
    private String password;
    private String email;
    private String addr;

    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEmail(this.email);
        user.setAddr(this.addr);
        return user;
        // return new User(null, username, password, email, addr, null, null); -> 깔금한데
        // 코드 파악이 어려움
    }
}
